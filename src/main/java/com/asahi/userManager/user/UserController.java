package com.asahi.userManager.user;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class UserController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello Worldasdasd!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(UserController.class, args);
    }
}