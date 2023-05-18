package com.geekster.Restaurant.Manangement.System.service;

import com.geekster.Restaurant.Manangement.System.model.FoodItem;
import com.geekster.Restaurant.Manangement.System.model.User;
import com.geekster.Restaurant.Manangement.System.repo.IFoodRepo;
import com.geekster.Restaurant.Manangement.System.repo.IUserRepo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FoodItemService {
    @Autowired
    IUserRepo iUserRepo;
    @Autowired
    IFoodRepo iFoodRepo;
    public boolean addFoodItem(Long id, FoodItem foodItem) {
        User user = iUserRepo.findById(id).get();
        boolean flag = user.getEmail().endsWith("@admin.com");
        if(flag){
            iFoodRepo.save(foodItem);
            return true;
        }
        return false;
    }

    public boolean updateFoodItem(Long id, FoodItem foodItem) {
        User user=iUserRepo.findById(id).get();
        boolean userEmail=user.getEmail().endsWith("@admin.com");
        if(userEmail){
             foodItem.setTitle(foodItem.getTitle());
             foodItem.setDescription(foodItem.getDescription());
             foodItem.setPrice(foodItem.getPrice());
             foodItem.setDummyImageUrl(foodItem.getDummyImageUrl());
             iFoodRepo.save(foodItem);
             return true;
        }
        return false;
    }

    public boolean deleteFoodItem(Long id, Long foodItemId) {
        User user=iUserRepo.findById(id).get();
        boolean userEmail=user.getEmail().endsWith("@admin.com");
        if(userEmail){
            iFoodRepo.deleteById(foodItemId);
            return true;
        }
            return false;
    }

    public FoodItem getFoodItem(Long id) {
        return iFoodRepo.findById(id).get();
    }
}
