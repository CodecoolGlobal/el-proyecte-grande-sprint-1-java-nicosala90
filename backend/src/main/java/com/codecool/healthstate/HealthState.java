package com.codecool.healthstate;

import com.codecool.data.user.Gender;
import com.codecool.data.user.User;

import java.util.ArrayList;
import java.util.List;

public class HealthState {

    private List<User> users;

    public HealthState() {
        this.users = new ArrayList<>();
    }
    public void addUser(User user){
        users.add(user);
    }
    public User getUserById(int id){
        return users.stream().filter(user -> user.getId() == id).findFirst().orElseThrow();
    }

}
