package com.example.Food.Delivery.App.Service;

import com.example.Food.Delivery.App.Repo.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    AdminRepo adminRepo;
}
