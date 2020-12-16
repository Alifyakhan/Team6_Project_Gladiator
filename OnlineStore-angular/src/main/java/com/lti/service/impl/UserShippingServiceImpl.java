package com.lti.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.domain.UserShipping;
import com.lti.repository.UserShippingRepository;
import com.lti.service.UserShippingService;


@Service
public class UserShippingServiceImpl implements UserShippingService{
	
	@Autowired
	private UserShippingRepository userShippingRepository;
	
	public Optional<UserShipping> findById(Long id) {
		return userShippingRepository.findById(id);
	}
	
	public void removeById(Long id) {
		userShippingRepository.deleteById(id);
	}
}

