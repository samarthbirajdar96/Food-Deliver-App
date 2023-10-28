package com.example.Food.Delivery.App.Service;

import com.example.Food.Delivery.App.Model.Food;
import com.example.Food.Delivery.App.Model.FoodType;
import com.example.Food.Delivery.App.Repo.FoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    FoodRepo foodRepo;


    public String addfood(Food food) {
        foodRepo.save(food);
        return "food added";
    }


    public List<Food> getallfood() {
        return foodRepo.findAll();

    }

    public String updatefoodbyId(Long id, FoodType foodtype) {
        Food food = foodRepo.findById(id).orElseThrow();
        if (id != null) {
            food.setFoodtype(foodtype);
            foodRepo.save(food);
            return "updated";
        } else {
            return null;
        }
    }

    public String deletefoodbyid(Long id) {
        Food food = foodRepo.findById(id).orElseThrow();
        if (id != null) {
            foodRepo.deleteById(id);
            return "deleted";
        } else {
            return "not found";
        }
    }


}
