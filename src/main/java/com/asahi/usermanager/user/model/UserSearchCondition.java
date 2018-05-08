package com.asahi.usermanager.user.model;

public class UserSearchCondition {
    public UserSearchCondition() {}
    
    private String name;
    private String gender;

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}
