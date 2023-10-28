package com.example.Food.Delivery.App.Repo;

import com.example.Food.Delivery.App.Model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepo extends JpaRepository<Food,Long> {
}
