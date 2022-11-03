package com.example.firebase.springbootfirebasebotsinred.controllers;


import com.example.firebase.springbootfirebasebotsinred.entities.Schedule;
import com.example.firebase.springbootfirebasebotsinred.entities.User;
import com.example.firebase.springbootfirebasebotsinred.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class UserController {

    private List<User> users;
    @Autowired
    private UserService userService;

    @GetMapping("/{deviceID}/getuser")
    public <T> T getUsers(@PathVariable String deviceID) throws ExecutionException, InterruptedException {
        users = userService.getUsers(deviceID);
        if( users.isEmpty() ){
            return (T) new String("false");
        }
        return (T) new ArrayList<>(users);
    }


    @GetMapping("/{deviceID}/getuser/{userID}")
    public User getUser(@PathVariable String userID ) throws ExecutionException, InterruptedException {
        return userService.getUser(userID);
    }
}
