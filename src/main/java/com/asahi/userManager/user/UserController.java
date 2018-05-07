package com.asahi.userManager.user;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

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
    public String getUserById(@PathVariable("id") String id) {
        return "Hello: " + id;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(UserController.class, args);
    }
}