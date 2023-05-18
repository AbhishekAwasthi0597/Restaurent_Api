package com.geekster.Restaurant.Manangement.System.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignInInput {
    private String email;
    private  String userPassword;
}
