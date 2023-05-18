package com.geekster.Restaurant.Manangement.System.repo;

import com.geekster.Restaurant.Manangement.System.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User,Long> {

    User findFirstByEmail(String email);
}
