package com.library.main;

public class User {
    private int userId;
    private String name;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public void display() {
        System.out.println(userId + " | " + name);
    }
}