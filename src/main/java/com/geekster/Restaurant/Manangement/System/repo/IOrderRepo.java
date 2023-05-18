package com.geekster.Restaurant.Manangement.System.repo;

import com.geekster.Restaurant.Manangement.System.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepo extends JpaRepository<Order,Long> {
}
