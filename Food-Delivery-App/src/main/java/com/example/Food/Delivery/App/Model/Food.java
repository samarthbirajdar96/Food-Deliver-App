package com.example.Food.Delivery.App.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Food  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodId;private String foodTitle;
    private String foodDesc;
    private double foodPrice;

    @Enumerated(value = EnumType.STRING)
    private FoodType foodtype;
}
