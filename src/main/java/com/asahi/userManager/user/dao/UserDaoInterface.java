package com.asahi.userManager.user.dao;

import java.util.List;

import com.asahi.userManager.user.bean.User;
import com.asahi.userManager.user.bean.UserSearchCondition;

public interface UserDaoInterface {
	User getUserById(long mongoId);
	User saveUser(User user);
	User removeUser(User user);
	List<User> searchUsers(UserSearchCondition condition);
}
