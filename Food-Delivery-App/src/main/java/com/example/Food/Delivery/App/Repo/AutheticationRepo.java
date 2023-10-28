package com.example.Food.Delivery.App.Repo;

import com.example.Food.Delivery.App.Model.AuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutheticationRepo extends JpaRepository<AuthenticationToken,Long>{

    AuthenticationToken findFirstByTokenValue(String tokenValue);
}