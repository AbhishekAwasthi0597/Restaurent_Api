package com.geekster.Restaurant.Manangement.System.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpInput {
    private String username;
    private String email;
    private String password;
    private String role;
}
