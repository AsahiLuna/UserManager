package com.asahi.usermanager.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asahi.usermanager.user.dao.AdminRepository;
import com.asahi.usermanager.user.model.Admin;
import com.asahi.usermanager.user.model.User;
import com.asahi.usermanager.user.service.AdminServiceI;

@Service
public class AdminServiceImpl implements AdminServiceI {

    @Autowired
    AdminRepository repository;

    public Admin getUserById(String mongoId) {
        // TODO Auto-generated method stub
        return null;
    }

    public Admin saveAdmin(Admin admin) {
        // TODO Auto-generated method stub
        return null;
    }

    public Admin removeAdminById(String mongoId) {
        // TODO Auto-generated method stub
        return null;
    }
}

