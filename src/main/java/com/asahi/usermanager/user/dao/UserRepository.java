package com.asahi.usermanager.user.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.asahi.usermanager.user.model.User;

public interface UserRepository extends MongoRepository<User, String>{

    Page<User> findAllByIsDeleted(boolean isDeleted, Pageable pageable);
    
    Page<User> findAllByNameLikeAndIsDeleted(String name, boolean isDeleted, Pageable pageable);
}
