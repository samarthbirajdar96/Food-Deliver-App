package com.example.Food.Delivery.App.Repo;

import com.example.Food.Delivery.App.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Orders,Integer> {


}
