package com.codecool.healthstate;

import java.util.ArrayList;
import java.util.List;

import com.codecool.controller.UserNotFoundException;
import com.codecool.data.user.User;

public class HealthState {

    private List<User> users;

    public HealthState() {
        this.users = new ArrayList<>();
    }
    public void addUser(User user){
        users.add(user);
    }
    public User getUserById(int id){
        return users.stream().filter(user -> user.getId() == id).findFirst()
                .orElseThrow(() -> new UserNotFoundException(id));
    }

}
