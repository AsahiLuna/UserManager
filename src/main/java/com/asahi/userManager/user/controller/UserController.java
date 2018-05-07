package com.asahi.userManager.user.controller;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.asahi.userManager.user.bean.User;

@Controller
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserController {

    
    @ResponseBody
    @RequestMapping("/")
    public String home() {
        return "Hello Worldasdasd!";
    }
    
    @ResponseBody
    @RequestMapping("/{id}")
    public User getUserById(@PathVariable("id") String id) {
        return new User(Long.parseLong(id), "Hello");
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(UserController.class, args);
    }
}