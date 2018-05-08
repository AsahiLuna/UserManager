package com.asahi.usermanager.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.asahi.usermanager.user.model.User;
import com.asahi.usermanager.user.service.UserServiceI;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserServiceI userDao;
    
    @ResponseBody
    @RequestMapping("/{id}")
    public User getUserById(@PathVariable("id") String id) {
        return userDao.getUserById(id);
    }
    
    @ResponseBody
    @RequestMapping("/save/{name}")
    public User saveUser(@PathVariable("name") String name) {
        return userDao.saveUser(new User(name));
    }
}