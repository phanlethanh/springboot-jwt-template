package com.thanhpl.jwt.api.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/bcrypt")
	public ResponseEntity<String> getVersion(@RequestBody String input) {
		JSONObject inputJson = new JSONObject(input);
		String password = inputJson.getString("password");
		
		String encodedPassword = bCryptPasswordEncoder.encode(password);
		JSONObject json = new JSONObject();
		json.put("encoded", encodedPassword);
		json.put("isValid", passwordEncoder.matches(password, encodedPassword));
		
		return ResponseEntity.ok(json.toString());
	}
}
