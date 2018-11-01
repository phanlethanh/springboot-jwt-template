package com.thanhpl.jwt.api.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thanhpl.jwt.api.dto.request.RegisterUserRequest;
import com.thanhpl.jwt.api.dto.response.RegisterUserResponse;
import com.thanhpl.jwt.api.dto.response.RegisterUserResponseData;
import com.thanhpl.jwt.api.model.User;
import com.thanhpl.jwt.api.service.UserService;
import com.thanhpl.jwt.api.utility.JsonUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = {
		"http://localhost:3000",
		"https://example.com"
		}, maxAge = 3600)
@RestController
public class RegisterUserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public RegisterUserResponse registerUser(@RequestBody RegisterUserRequest request) {
		log.info(JsonUtil.toJson(request));
		RegisterUserResponse response = new RegisterUserResponse();
		RegisterUserResponseData data = new RegisterUserResponseData();
		User user = new User();
		try {
			Long nextId = userService.getNextId();
			user.setUserId(nextId.toString());
			user.setUsername(request.getUsername());
			user.setPassword(request.getPassword());
			user.setFullName(request.getFullName());
			user.setRoleId("2");// Default
			user.setCreateTime(new Date());
			userService.save(user);
			data.setStatus("Registered");
			response.setData(data);
			response.setSuccess(true);
			response.setCode("0");
			response.setMessage("Success");
		} catch (Exception e) {
			log.error("Register user error", e);
			response.setSuccess(false);
			response.setCode("900");
			response.setMessage("Server error");
		}
		
		log.info(JsonUtil.toJson(response));
		return response;
	}
}
