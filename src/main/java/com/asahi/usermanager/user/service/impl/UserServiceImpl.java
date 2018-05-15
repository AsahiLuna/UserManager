package com.asahi.usermanager.user.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.asahi.usermanager.user.dao.UserRepository;
import com.asahi.usermanager.user.model.User;
import com.asahi.usermanager.user.model.UserSearchCondition;
import com.asahi.usermanager.user.service.UserServiceI;

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
        PageRequest pageRequest = buildPageRequest(condition.getPageNumber(), condition.getPageSize(), "updatedDate");
        if (condition.getName() == null || condition.getName().isEmpty()) {
            return repository.findAllByIsDeleted(false, pageRequest);
        } else {            
            return repository.findAllByNameLikeAndIsDeleted(condition.getName(), false, pageRequest);
        }
    }

    private PageRequest buildPageRequest(int page, int size, String sort) {
        return new PageRequest(page, size, Direction.DESC, sort);
    }
}
