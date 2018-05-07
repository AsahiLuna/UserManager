package com.asahi.usermanager.user.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import com.asahi.usermanager.user.model.User;

public interface UserRepository extends MongoRepository<User, String>{

	List<User> findByName(@Param("name") String name);
}
