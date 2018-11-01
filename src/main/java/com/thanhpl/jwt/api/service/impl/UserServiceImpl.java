package com.thanhpl.jwt.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.thanhpl.jwt.api.model.User;
import com.thanhpl.jwt.api.repository.UserRepository;
import com.thanhpl.jwt.api.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public Long getNextId() {
		return userRepository.getNextId();
	}

	@Override
	public User save(User user) {
		if (user == null) {
			return null;
		}
		// Encode password with BCrypt
		String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		return userRepository.save(user);
	}
	
}
