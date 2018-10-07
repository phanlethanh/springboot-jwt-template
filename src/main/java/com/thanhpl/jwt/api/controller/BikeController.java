package com.thanhpl.jwt.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thanhpl.jwt.api.dto.request.SaveBikeRequest;
import com.thanhpl.jwt.api.dto.response.SaveBikeResponse;
import com.thanhpl.jwt.api.dto.response.SaveBikeResponseData;
import com.thanhpl.jwt.api.model.Bike;
import com.thanhpl.jwt.api.service.BikeService;
import com.thanhpl.jwt.api.utility.JsonUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = {
		"http://localhost:3000",
		"https://example.com"
		}, maxAge = 3600)
@RestController
@RequestMapping(value = "/v1")
public class BikeController {
	
	@Autowired
	private BikeService bikeService;
	
	@RequestMapping(value = "/bike/save", method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('USER')")
	public SaveBikeResponse saveBike(@RequestBody SaveBikeRequest request) {
		log.info(JsonUtil.toJson(request));
		SaveBikeResponse response = new SaveBikeResponse();
		SaveBikeResponseData data = new SaveBikeResponseData();
		
		Bike bike = new Bike();
		bike.setBikeId("2");
		bike.setName(request.getName());
		bike.setColor(request.getColor());
		bike.setModel(request.getModel());
		
		try {
			bike = bikeService.save(bike);
			if (bike != null) {
				data.setId(bike.getBikeId());
				response.setData(data);
				response.setSuccess(true);
				response.setCode("0");
				response.setMessage("Success");
			} else {
				response.setSuccess(false);
				response.setCode("900");
				response.setMessage("System error");
			}
		} catch (Exception e) {
			log.error("Save bike error", e);
		}
		
		log.info(JsonUtil.toJson(response));
		return response;
	}
}
