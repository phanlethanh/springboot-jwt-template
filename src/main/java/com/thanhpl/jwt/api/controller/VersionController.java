package com.thanhpl.jwt.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thanhpl.jwt.api.config.AppProperties;



@RestController
@RequestMapping({ "/" })
public class VersionController {
	
	@Autowired
	private AppProperties appProperties;

	@GetMapping("/version")
	public ResponseEntity<String> getVersion() {
		return ResponseEntity.ok(appProperties.getProjectVersion());
	}
	
}