package com.geekster.Restaurant.Manangement.System.service;

import com.geekster.Restaurant.Manangement.System.model.AuthenticationToken;
import com.geekster.Restaurant.Manangement.System.model.User;
import com.geekster.Restaurant.Manangement.System.repo.ITokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    ITokenRepo iTokenRepo;


    public void saveToken(AuthenticationToken token) {
          iTokenRepo.save(token);
    }

    public AuthenticationToken getToken(User user) {
        return iTokenRepo.findByUser(user);
    }
}
