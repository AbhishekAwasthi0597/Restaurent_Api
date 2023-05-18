package com.geekster.Restaurant.Manangement.System.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(unique = true)
    private String username;
    @Column(unique = true)

    private String email;
    private String password;
    private String role;
    public User(String username,String email,String password,String role){
        this.username=username;
        this.email=email;
        this.password=password;
        this.role=role;
    }


}
