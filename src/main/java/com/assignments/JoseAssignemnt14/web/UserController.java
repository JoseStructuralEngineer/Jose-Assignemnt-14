package com.assignments.JoseAssignemnt14.web;


import com.assignments.JoseAssignemnt14.domain.User;
import com.assignments.JoseAssignemnt14.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserServices userServices;


    @PostMapping("/users")
    public User getCreateUser(@RequestBody String name){
         return userServices.createUser(name);
    }


}
