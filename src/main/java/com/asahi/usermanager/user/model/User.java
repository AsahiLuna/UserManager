package com.asahi.usermanager.user.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document(collection = "mongo_user")
public class User {

	@Id
	private String id;
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getUserName() {
        return name;
    }
}
