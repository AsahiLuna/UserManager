package com.asahi.userManager.user.bean;

public class User {

    private final long id;
    private final String userName;

    public User(long id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }
}
