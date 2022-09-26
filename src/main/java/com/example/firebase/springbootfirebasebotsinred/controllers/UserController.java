package com.example.firebase.springbootfirebasebotsinred.controllers;


import com.example.firebase.springbootfirebasebotsinred.entities.Schedule;
import com.example.firebase.springbootfirebasebotsinred.entities.User;
import com.example.firebase.springbootfirebasebotsinred.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{deviceID}/users")
    public List<User> getUsers(@PathVariable String deviceID) throws ExecutionException, InterruptedException {
        return userService.getUsers(deviceID);
    }


    @GetMapping("/{deviceID}/users/{userID}")
    public User getUser(@PathVariable String userID ) throws ExecutionException, InterruptedException {
        return userService.getUser(userID);
    }
}
