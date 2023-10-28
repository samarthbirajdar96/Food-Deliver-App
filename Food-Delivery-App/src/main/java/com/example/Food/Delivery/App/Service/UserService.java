package com.example.Food.Delivery.App.Service;

import com.example.Food.Delivery.App.Model.AuthenticationToken;
import com.example.Food.Delivery.App.Model.Dto.AuthenticationInputDto;
import com.example.Food.Delivery.App.Model.Dto.SignInputDto;
import com.example.Food.Delivery.App.Model.Orders;
import com.example.Food.Delivery.App.Model.User;
import com.example.Food.Delivery.App.Repo.OrderRepo;
import com.example.Food.Delivery.App.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    AutheticationService autheticationService;

    @Autowired
    OrderRepo orderRepo;

    public String userSignUp(User user) {
        String newEmail = user.getUserEmail();

        User existingUser = userRepo.findFirstByUserEmail(newEmail);

        if (existingUser != null) {
            return "email already in use";
        }

        // passwords are encrypted before we store it in the table

        String signUpPassword = user.getUserPassword();

        try {
            String encryptedPassword = PasswordEncryptor.encrypt(signUpPassword);

            user.setUserPassword(encryptedPassword);


            // user table - save user
            userRepo.save(user);
            return "user registered";

        } catch (NoSuchAlgorithmException e) {

            return "Internal Server issues while saving password, try again later!!!";
        }

    }

    public String userSignIn(SignInputDto signInInput) {
        String email = signInInput.getEmail();

        User existinguser = userRepo.findFirstByUserEmail(email);

        if (existinguser == null) {
            return "Not a valid email, Please sign up first !!!";
        }

        //password should be matched

        String password = signInInput.getPassword();


        try {
            String encryptedPassword = PasswordEncryptor.encrypt(password);

            if (existinguser.getUserPassword().equals(encryptedPassword)) {
                // return a token for this sign in
                AuthenticationToken token = new AuthenticationToken(existinguser);
                autheticationService.createToken(token);
                return token.getTokenValue();
            } else {
                //password was wrong!!!
                return "Invalid Credentials!!!";
            }

        } catch (NoSuchAlgorithmException e) {

            return "Internal Server issues while saving password, try again later!!!";
        }


    }

    public String userSignOut(AuthenticationInputDto authInfo) {
        if(autheticationService.authenticate(authInfo)) {
            String tokenValue = authInfo.getTokenValue();
            autheticationService.deleteToken(tokenValue);
            return "Sign Out successful!!";
        }
        else {
            return "Un Authenticated access!!!";
        }

    }


    public List<Orders> gethistory() {
        return orderRepo.findAll();
    }
}





