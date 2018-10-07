package com.thanhpl.jwt.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thanhpl.jwt.api.dto.UserDto;
import com.thanhpl.jwt.api.dto.request.GetUserRequest;
import com.thanhpl.jwt.api.dto.response.GetUserResponse;
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
@RequestMapping(value = "/v1")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('ADMIN')")
	public GetUserResponse saveBike(@RequestBody GetUserRequest request) {
		log.info(JsonUtil.toJson(request));
		GetUserResponse response = new GetUserResponse();
		UserDto data = new UserDto();
		User user = null;
		
		try {
			user = userService.findByUsername(request.getUsername());
			if (user != null) {
				data.setUserId(user.getUserId());
				data.setUsername(user.getUsername());
				data.setFullName(user.getFullName());
				data.setCreateTime(user.getCreateTime());
				data.setUpdateTime(user.getUpdateTime());
				response.setData(data);
				response.setSuccess(true);
				response.setCode("0");
				response.setMessage("Success");
			} else {
				response.setSuccess(false);
				response.setCode("10");
				response.setMessage("Not found");
			}
		} catch (Exception e) {
			log.error("Get user error", e);
		}
		
		log.info(JsonUtil.toJson(response));
		return response;
	}
}
