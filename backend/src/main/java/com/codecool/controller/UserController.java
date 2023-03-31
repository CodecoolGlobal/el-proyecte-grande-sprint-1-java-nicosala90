package com.codecool.controller;

import com.codecool.data.user.User;
import com.codecool.healthstate.HealthState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private HealthState healthState;

    @Autowired
    public UserController(HealthState healthState) {
        this.healthState = healthState;
    }

    @PostMapping("/actual-user")
    public double addUser(@RequestBody User user){
        healthState.addUser(user);
        return user.calculateBMI();
    }

    @GetMapping("/{id}")
    public double getBMI(@PathVariable int id){
        return healthState.getUserById(id).calculateBMI();
    }
}
