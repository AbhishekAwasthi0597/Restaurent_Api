package com.geekster.Restaurant.Manangement.System.repo;

import com.geekster.Restaurant.Manangement.System.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFoodRepo extends JpaRepository<FoodItem,Long> {
}
