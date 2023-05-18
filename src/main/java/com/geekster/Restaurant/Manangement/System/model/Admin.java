package com.geekster.Restaurant.Manangement.System.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RestaurantAdmin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;
    @Column(nullable = false)
    @NotEmpty
    private String Name;

    @NotBlank
    @Column(unique = true , nullable = false)
    @Email
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@admin\\.com$")
    private  String email;
}
