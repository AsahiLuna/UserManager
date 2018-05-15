package com.asahi.usermanager.user.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.asahi.usermanager.user.model.Admin;

public interface AdminRepository extends MongoRepository<Admin, String>{
    Admin findByUsername(String username);
}
