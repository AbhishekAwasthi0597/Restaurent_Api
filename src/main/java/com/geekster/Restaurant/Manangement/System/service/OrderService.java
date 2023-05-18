package com.geekster.Restaurant.Manangement.System.service;

import com.geekster.Restaurant.Manangement.System.model.Order;
import com.geekster.Restaurant.Manangement.System.model.User;
import com.geekster.Restaurant.Manangement.System.repo.IOrderRepo;
import com.geekster.Restaurant.Manangement.System.repo.IUserRepo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    IOrderRepo iOrderRepo;
    @Autowired
    IUserRepo iUserRepo;
    public boolean addOrder(Long id, Order order) {
        if(iUserRepo.findById(id).isPresent()){
            iOrderRepo.save(order);
            return true;
        }
        return false;
    }

    public List<Order> getOrdersByUserId(Long userId) {
        return iOrderRepo.findAllById(Collections.singleton(userId));
    }

    public Order getOrderById(Long orderId) {
        Optional<Order> optionalOrder = iOrderRepo.findById(orderId);
        return optionalOrder.orElse(null);
    }

    public Order updateOrder(Long orderId, Order order) {
        Order existingOrder = getOrderById(orderId);
        if (existingOrder != null) {
            return iOrderRepo.save(existingOrder);
        }
        return null;
    }

    public void deleteOrder(Long orderId) {
        iOrderRepo.deleteById(orderId);
    }
}
