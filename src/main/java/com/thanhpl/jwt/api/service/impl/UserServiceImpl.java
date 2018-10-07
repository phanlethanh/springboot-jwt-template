package com.thanhpl.jwt.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thanhpl.jwt.api.model.User;
import com.thanhpl.jwt.api.repository.UserRepository;
import com.thanhpl.jwt.api.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
}
