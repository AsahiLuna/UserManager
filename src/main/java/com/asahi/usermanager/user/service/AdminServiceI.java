package com.asahi.usermanager.user.service;

import org.springframework.stereotype.Component;

import com.asahi.usermanager.user.model.Admin;
import com.asahi.usermanager.user.model.User;

@Component
public interface AdminServiceI {
    Admin getUserById(String mongoId);
    Admin saveAdmin(Admin admin);
    Admin removeAdminById(String mongoId);
}
