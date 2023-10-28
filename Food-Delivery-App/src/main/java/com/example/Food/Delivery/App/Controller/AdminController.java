package com.example.Food.Delivery.App.Controller;

import com.example.Food.Delivery.App.Model.Dto.AuthenticationInputDto;
import com.example.Food.Delivery.App.Model.Food;
import com.example.Food.Delivery.App.Model.FoodType;
import com.example.Food.Delivery.App.Model.Orders;
import com.example.Food.Delivery.App.Service.AdminService;
import com.example.Food.Delivery.App.Service.FoodService;
import com.example.Food.Delivery.App.Service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Validated
@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    OrderService orderService;

    @Autowired
    FoodService foodService;

    @PostMapping("food")
    public String addfood(@RequestBody Food food) {
        return foodService.addfood(food);
    }

    @GetMapping("foods")
    public List<Food> getallfood() {
        return foodService.getallfood();
    }

    @PutMapping("food/id/{id}/foodtype/{foodtype}")
    public String updatefoodbyId(@PathVariable Long id, @PathVariable FoodType foodtype){
        return foodService.updatefoodbyId(id,foodtype);
    }

    @DeleteMapping("food/id/{id}")
    public String deletefoodbyid(@PathVariable Long id){
        return foodService.deletefoodbyid(id);
    }

    @GetMapping("orders")
    public List<Orders> getAllOrders()
    {
        return orderService.getAllOrders();
    }

}
