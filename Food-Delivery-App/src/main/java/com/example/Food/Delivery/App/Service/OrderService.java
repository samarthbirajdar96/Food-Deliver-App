package com.example.Food.Delivery.App.Service;

import com.example.Food.Delivery.App.Model.Dto.AuthenticationInputDto;
import com.example.Food.Delivery.App.Model.Food;
import com.example.Food.Delivery.App.Model.Orders;
import com.example.Food.Delivery.App.Model.User;
import com.example.Food.Delivery.App.Repo.FoodRepo;
import com.example.Food.Delivery.App.Repo.OrderRepo;
import com.example.Food.Delivery.App.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    AutheticationService autheticationService;
    
    @Autowired
    FoodRepo foodRepo;


    public String addOrder(AuthenticationInputDto authInfo, Orders order) {
        if (autheticationService.authenticate(authInfo)) {
            String email = authInfo.getEmail();

            User user = userRepo.findFirstByUserEmail(email);

            order.setUser(user);
            Long foodId = order.getFood().getFoodId();

            Food food = foodRepo.findById(foodId).orElseThrow();

            order.setFood(food);

            if (food != null) {
                order.setCreatedAt(LocalDateTime.now());
                orderRepo.save(order);
                return "order booked at time :" + order.getCreatedAt() + "with " + food.getFoodtype();

            } else {
                return "Food not exit!!!";
            }
        }else{
            return "un authetication access!!";
        }
    }


    public String cancelorder(AuthenticationInputDto authInfo, Integer orderId) {
        if(autheticationService.authenticate(authInfo)) {

            String email = authInfo.getEmail();

            User user = userRepo.findFirstByUserEmail(email);

            Orders existingorder =  orderRepo.findById(orderId).orElseThrow();

            if(existingorder.getUser().equals(user))
            {
                orderRepo.deleteById(orderId);
                return "order with " + existingorder.getFood().getFoodtype() + " has been cancelled!!";

            }
            else
            {
                return "UnAuthorized cancel order!!";
            }

        }
        else {
            return "Un Authenticated access!!!";
        }
    }


          public List<Orders> getAllOrders() {
            return orderRepo.findAll();
        }


}
