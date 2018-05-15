package com.asahi.usermanager.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.asahi.usermanager.user.model.Admin;
import com.asahi.usermanager.user.service.AdminServiceI;

@RestController
@RequestMapping("/admins")
public class AdminController {

	@Autowired
	AdminServiceI service;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@ResponseBody
    @GetMapping("")
    public String home() {
        return "Connected";
    }
    
	@PostMapping("/signup")
    public Admin signUp(@RequestBody Admin admin) {
	    admin.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));
        return service.saveAdmin(admin);
    }
    
    
}