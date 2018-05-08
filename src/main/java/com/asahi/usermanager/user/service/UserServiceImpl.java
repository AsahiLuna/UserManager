package com.asahi.usermanager.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asahi.usermanager.user.dao.UserRepository;
import com.asahi.usermanager.user.model.User;
import com.asahi.usermanager.user.model.UserSearchCondition;

@Service
public class UserServiceImpl implements UserServiceI {

    @Autowired
    UserRepository respository;

    public User getUserById(String mongoId) {
        return respository.findOne(mongoId);
    }

    public User saveUser(User user) {
        return respository.save(user);
    }

    public User removeUserById(String mongoId) {
        User targetUser = respository.findOne(mongoId);
        if (targetUser != null) {
            if (!targetUser.isDeleted()) {
                targetUser.setDeleted(true);
                return respository.save(targetUser);
            }
        }
        return targetUser;
    }

    public List<User> searchUsers(UserSearchCondition condition) {
        // TODO Auto-generated method stub
        return null;
    }
}
