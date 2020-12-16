package com.lti.service;

import java.util.Optional;

import com.lti.domain.UserPayment;

public interface UserPaymentService {
	Optional<UserPayment> findById(Long id);
	
	void removeById(Long id);

}
