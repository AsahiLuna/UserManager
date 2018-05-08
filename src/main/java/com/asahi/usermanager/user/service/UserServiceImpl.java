package com.asahi.usermanager.user.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.asahi.usermanager.user.dao.UserRepository;
import com.asahi.usermanager.user.model.User;
import com.asahi.usermanager.user.model.UserSearchCondition;

@Service
public class UserServiceImpl implements UserServiceI {

    @Autowired
    UserRepository repository;

    public User getUserById(String mongoId) {
        return repository.findOne(mongoId);
    }

    public User saveUser(User user) {
        return repository.save(user);
    }

    public User removeUserById(String mongoId) {
        User targetUser = repository.findOne(mongoId);
        if (targetUser != null) {
            if (!targetUser.isDeleted()) {
                targetUser.setDeleted(true);
                return repository.save(targetUser);
            }
        }
        return targetUser;
    }

    public Page<User> searchUsers(UserSearchCondition condition) {
        PageRequest pageRequest = buildPageRequest(0,5,null);
        return repository.findAll(pageRequest);
    }

    private PageRequest buildPageRequest(int page, int size, Sort sort) {
        return new PageRequest(page, size, sort);
    }
}
