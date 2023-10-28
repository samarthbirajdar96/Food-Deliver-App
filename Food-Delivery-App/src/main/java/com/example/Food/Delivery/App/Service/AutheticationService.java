package com.example.Food.Delivery.App.Service;

import com.example.Food.Delivery.App.Model.AuthenticationToken;
import com.example.Food.Delivery.App.Model.Dto.AuthenticationInputDto;
import com.example.Food.Delivery.App.Repo.AutheticationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutheticationService {

    @Autowired
    AutheticationRepo autheticationRepo;


    public void createToken(AuthenticationToken token) {
        autheticationRepo.save(token);
    }

    public boolean authenticate(AuthenticationInputDto authInfo) {
        String email = authInfo.getEmail();
        String tokenValue = authInfo.getTokenValue();


        AuthenticationToken token =  autheticationRepo.findFirstByTokenValue(tokenValue);
        if(token!=null)
        {
            return token.getUser().getUserEmail().equals(email);
        }
        else
        {
            return false;
        }

    }

    public void deleteToken(String tokenValue) {
         AuthenticationToken token=autheticationRepo.findFirstByTokenValue(tokenValue);
         autheticationRepo.delete(token);
    }
}

