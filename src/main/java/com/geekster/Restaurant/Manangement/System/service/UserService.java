package com.geekster.Restaurant.Manangement.System.service;

import com.geekster.Restaurant.Manangement.System.dto.SignInInput;
import com.geekster.Restaurant.Manangement.System.dto.SignInOutput;
import com.geekster.Restaurant.Manangement.System.dto.SignUpInput;
import com.geekster.Restaurant.Manangement.System.dto.SignUpOutput;
import com.geekster.Restaurant.Manangement.System.model.AuthenticationToken;
import com.geekster.Restaurant.Manangement.System.model.User;
import com.geekster.Restaurant.Manangement.System.repo.IUserRepo;
import jakarta.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UserService {
    @Autowired
    IUserRepo iUserRepo;
    @Autowired
    AuthenticationService authenticationService;
    public SignUpOutput signup(SignUpInput signDto) {
            User user = iUserRepo.findFirstByEmail(signDto.getEmail());
            if (user != null) {
                throw new IllegalStateException("User Already exist!!!...");
            }
            String encryptedPassword = null;
            try {
                encryptedPassword = encryptPassword(signDto.getPassword());
            } catch (Exception e) {
                e.printStackTrace();
            }
            user = new User(signDto.getUsername(), signDto.getEmail(), encryptedPassword, signDto.getRole());
            iUserRepo.save(user);
            AuthenticationToken token = new AuthenticationToken(user);
            authenticationService.saveToken(token);
            return new SignUpOutput("User registered", "User created successfully");

    }
    private String encryptPassword(String userPassword) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(userPassword.getBytes());
        byte[] digested =  md5.digest();

        String hash = DatatypeConverter.printHexBinary(digested);
        return hash;
    }

    public SignInOutput signin(SignInInput signInDto) {
        User user=iUserRepo.findFirstByEmail(signInDto.getEmail());
        if(user==null){
            throw new IllegalStateException("User is Invalid!!!...");
        }
        String encryptedPassword = null;
        try{
            encryptedPassword = encryptPassword(signInDto.getUserPassword());
        }catch(Exception e){
            e.printStackTrace();
        }
        boolean isPasswordValid = encryptedPassword.equals(user.getPassword());
        if(!isPasswordValid){
            throw  new IllegalStateException("Password is in Valid or sign up");
        }
        AuthenticationToken authToken = authenticationService.getToken(user);
        return  new SignInOutput("Authentication Successfull !!!",authToken.getToken());
    }


}
