package com.thanhpl.jwt.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thanhpl.jwt.api.model.Bike;
import com.thanhpl.jwt.api.repository.BikeRepository;
import com.thanhpl.jwt.api.service.BikeService;

@Service
public class BikeServiceImpl implements BikeService {

	@Autowired
	private BikeRepository bikeRepository;
	
	@Override
	public Bike save(Bike bike) {
		return bikeRepository.save(bike);
	}

}
