package com.thanhpl.jwt.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.thanhpl.jwt.api.model.User;
import com.thanhpl.jwt.api.repository.RoleRepository;
import com.thanhpl.jwt.api.repository.UserRepository;

@Component
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(String.format("The username %s doesn't exist", username));
		}
		List<GrantedAuthority> authorities = new ArrayList<>();
		String[] privileges = roleRepository.getPrivileges(user.getRoleId()).split(",");
		for (int i = 0; i < privileges.length; i++) {
			authorities.add(new SimpleGrantedAuthority(privileges[i]));
		}
		UserDetails userDetails = new org.springframework.security.core.userdetails.
                User(user.getUsername(), user.getPassword(), authorities);

		return userDetails;
	}
}
