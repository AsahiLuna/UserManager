package com.asahi.usermanager.user.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mongo_user")
public class User {

    @Id
    private String id;
    private String name;

    public User() {}
    
    public User(String name) {
        this.name = name;
    }

    public User(User user) {
        this.id = user.id.isEmpty() ? this.id : user.id;
        this.name = user.name;
    }

	public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
