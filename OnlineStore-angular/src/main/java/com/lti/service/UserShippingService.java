package com.lti.service;

import java.util.Optional;

import com.lti.domain.UserShipping;

public interface UserShippingService {
	
	Optional<UserShipping> findById(Long id);
	
	void removeById(Long id);

}