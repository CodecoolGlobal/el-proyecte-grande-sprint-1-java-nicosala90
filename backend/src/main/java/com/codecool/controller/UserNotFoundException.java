package com.codecool.controller;

public class UserNotFoundException extends RuntimeException {

    private int id;

    public UserNotFoundException(int id) {
        this.id = id;

    }

    public UserNotFoundException(int id, Throwable cause) {
        super(cause);
        this.id = id;
    }

    @Override
    public String getMessage() {
        return "UserNotFoundException [id=" + id + "]";
    }

}
