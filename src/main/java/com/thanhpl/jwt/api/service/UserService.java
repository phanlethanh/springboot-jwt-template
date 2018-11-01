package com.thanhpl.jwt.api.service;

import com.thanhpl.jwt.api.model.User;

public interface UserService {
	User findByUsername(String username);
	
	Long getNextId();
	
	User save(User user);
}
