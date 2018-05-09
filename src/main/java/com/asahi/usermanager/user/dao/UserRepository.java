package com.asahi.usermanager.user.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.asahi.usermanager.user.model.User;

public interface UserRepository extends MongoRepository<User, String>{

    Page<User> findAllByIsDeleted(boolean isDeleted, Pageable pageable);
    
}
