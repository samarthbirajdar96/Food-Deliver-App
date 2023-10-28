package com.example.Food.Delivery.App.Controller;

import com.example.Food.Delivery.App.Model.Dto.AuthenticationInputDto;
import com.example.Food.Delivery.App.Model.Dto.OrderInputDto;
import com.example.Food.Delivery.App.Model.Dto.SignInputDto;
import com.example.Food.Delivery.App.Model.Orders;
import com.example.Food.Delivery.App.Model.User;
import com.example.Food.Delivery.App.Service.OrderService;
import com.example.Food.Delivery.App.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    @PostMapping("user/signup")
    public String userSignUp(@Valid @RequestBody User user)
    {

        return userService.userSignUp(user);
    }

    @PostMapping("user/signIn")
    public String userSignIn(@RequestBody SignInputDto signInInput)
    {
        return userService.userSignIn(signInInput);
    }

    @DeleteMapping("user/signOut")
    public String userSignOut(@RequestBody AuthenticationInputDto authInfo)
    {
        return userService.userSignOut(authInfo);
    }


    @PostMapping("order")
    public String addOrder(@RequestBody OrderInputDto orderInputDto)
    {
        return orderService.addOrder(orderInputDto.getAuthInfo(),orderInputDto.getOrder());
    }


    @DeleteMapping("user/order/{orderId}/cancel")
    public String cancelorder(@RequestBody AuthenticationInputDto authInfo, @PathVariable Integer orderId)
    {
        return orderService.cancelorder(authInfo,orderId);
    }



    @GetMapping("user/order/history")
    public List<Orders> gethistory(){
        return userService.gethistory();
    }


     }

