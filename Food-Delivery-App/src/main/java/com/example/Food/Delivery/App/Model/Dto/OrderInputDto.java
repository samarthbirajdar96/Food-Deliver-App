package com.example.Food.Delivery.App.Model.Dto;

import com.example.Food.Delivery.App.Model.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderInputDto {


    AuthenticationInputDto authInfo;
    Orders order;
}

