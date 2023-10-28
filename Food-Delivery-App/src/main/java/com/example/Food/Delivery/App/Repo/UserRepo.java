package com.example.Food.Delivery.App.Repo;

import com.example.Food.Delivery.App.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

    User findFirstByUserEmail(String newEmail);
}
