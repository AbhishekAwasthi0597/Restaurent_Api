package com.geekster.Restaurant.Manangement.System.controller;

import com.geekster.Restaurant.Manangement.System.model.FoodItem;
import com.geekster.Restaurant.Manangement.System.service.FoodItemService;
import com.geekster.Restaurant.Manangement.System.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("foodItem")
public class FoodItemController {
    @Autowired
    FoodItemService foodItemService;
    @Autowired
    UserService userService;
    @PostMapping()
    public ResponseEntity<String> addFoodItem(@RequestParam Long id, @RequestBody FoodItem foodItem){
        boolean flag = foodItemService.addFoodItem(id, foodItem);
        if(flag){
            return new ResponseEntity<>(foodItem.toString(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>("The entered Id is not Admin's Id",HttpStatus.BAD_REQUEST);
    }
    @PutMapping("{id}")
    public ResponseEntity<String> updateFoodItem(@PathVariable Long id,@RequestBody FoodItem foodItem){
        boolean flag = foodItemService.addFoodItem(id, foodItem);
        if(flag) {
            return new ResponseEntity<>(foodItem.toString(), HttpStatus.UPGRADE_REQUIRED);
        }
        return new ResponseEntity<>("The entered Id is not Admin's Id",HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping("{id}/{foodItemId}")
    public ResponseEntity<String> deleteFoodItem(@PathVariable Long id,@PathVariable Long foodItemId){
        boolean flag = foodItemService.deleteFoodItem(id,foodItemId);
        if(flag) {
            return new ResponseEntity<>(foodItemId.toString(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("The entered Id is not Admin's Id",HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/{id}")
    public ResponseEntity<FoodItem> getFoodItem(@PathVariable Long id){
        FoodItem foodItem=foodItemService.getFoodItem(id);
        return ResponseEntity.ok(foodItem);
    }
}
