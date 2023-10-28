package com.example.Food.Delivery.App.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    private Integer orderQuantity;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "fk_food_Id")
    private Food food;

    @ManyToOne
    @JoinColumn(name = "fk_user_Id")
    private User user;

}
