package com.geekster.Restaurant.Manangement.System.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "food_item_id")
    private FoodItem foodItem;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String status;
}
