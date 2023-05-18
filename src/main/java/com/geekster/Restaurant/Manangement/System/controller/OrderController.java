package com.geekster.Restaurant.Manangement.System.controller;

import com.geekster.Restaurant.Manangement.System.model.FoodItem;
import com.geekster.Restaurant.Manangement.System.model.Order;
import com.geekster.Restaurant.Manangement.System.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @PostMapping("{id}")
    public ResponseEntity<String> addOrder(@PathVariable Long id, @RequestBody Order order){
        boolean flag = orderService.addOrder(id, order);
        if(flag){
            return new ResponseEntity<>(order.toString(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>("The entered Id is not valid",HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<List<Order>> getOrdersByUserId(@PathVariable Long userId) {
        List<Order> orders = orderService.getOrdersByUserId(userId);
        return ResponseEntity.ok(orders);
    }
    @PutMapping("/{userId}/{orderId}")
    public ResponseEntity<Order> updateOrder(@PathVariable String userId, @PathVariable Long orderId, @RequestBody Order order) {
        Order existingOrder = orderService.getOrderById(orderId);
        if (existingOrder != null && existingOrder.getId().equals(userId)) {
            Order updatedOrder = orderService.updateOrder(orderId, order);
            return ResponseEntity.ok(updatedOrder);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @DeleteMapping("/{userId}/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable String userId, @PathVariable Long orderId) {
        Order existingOrder = orderService.getOrderById(orderId);
        if (existingOrder != null && existingOrder.getId().equals(userId)) {
            orderService.deleteOrder(orderId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
