package com.asahi.usermanager.user.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.asahi.usermanager.user.model.User;
import com.asahi.usermanager.user.model.UserSearchCondition;

@Component
public interface UserServiceI {
    User getUserById(String mongoId);
    User saveUser(User user);
    User removeUserById(String mongoId);
//    Page<User> searchUsers(UserSearchCondition condition);
}
