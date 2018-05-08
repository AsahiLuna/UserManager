package com.asahi.usermanager.user.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.asahi.usermanager.user.util.Constants;

@Document(collection = "mongo_user")
public class User {

    @Id
    private String id;
    private String name;
    private Date birthDate;
    private String gender;
    private String phoneNumber;
    private String email;
    
    private boolean isDeleted;


	public User() {}
    

    public User(String name) {
        this.name = name;
    }

    public User(User user) {
        this.id = user.id.isEmpty() ? this.id : user.id;
        this.name = user.name;
        this.isDeleted = user.isDeleted;
        this.birthDate = user.birthDate;
        this.email = user.email;
        if(user.gender.equals(Constants.MALE) || user.gender.equals(Constants.FEMALE)) {
            this.gender = user.gender;
        }else {
            this.gender = Constants.UNKNOWN;
        }
        this.phoneNumber = user.phoneNumber;
    }

	public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public boolean isDeleted() {
    	return isDeleted;
    }
    
    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
    
    public Date getBirthDate() {
        return birthDate;
    }
    
    
    public String getGender() {
        return gender;
    }
    
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    
    public String getEmail() {
        return email;
    }
}
