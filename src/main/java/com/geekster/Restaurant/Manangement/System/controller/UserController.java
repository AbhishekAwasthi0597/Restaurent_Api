package com.geekster.Restaurant.Manangement.System.controller;

import com.geekster.Restaurant.Manangement.System.dto.SignInInput;
import com.geekster.Restaurant.Manangement.System.dto.SignInOutput;
import com.geekster.Restaurant.Manangement.System.dto.SignUpInput;
import com.geekster.Restaurant.Manangement.System.dto.SignUpOutput;
import com.geekster.Restaurant.Manangement.System.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/signup")
    public SignUpOutput signup(@RequestBody SignUpInput signDto){
        return userService.signup(signDto);
    }
    @PostMapping("/signin")
    public SignInOutput signin(@RequestBody SignInInput signInDto){
        return  userService.signin(signInDto);
    }
}
