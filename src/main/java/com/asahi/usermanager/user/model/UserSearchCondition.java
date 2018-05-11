package com.asahi.usermanager.user.model;

public class UserSearchCondition {
    public UserSearchCondition() {}
    
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "UserSearchCondition [name=" + name + "]";
    }
    
    
}
