package com.geekster.Restaurant.Manangement.System.repo;

import com.geekster.Restaurant.Manangement.System.model.AuthenticationToken;
import com.geekster.Restaurant.Manangement.System.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITokenRepo extends JpaRepository<AuthenticationToken,Long> {
    AuthenticationToken findByUser(User user);
}
