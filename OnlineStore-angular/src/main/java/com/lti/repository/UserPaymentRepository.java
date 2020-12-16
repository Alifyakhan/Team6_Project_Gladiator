package com.lti.repository;

import org.springframework.data.repository.CrudRepository;

import com.lti.domain.UserPayment;

public interface UserPaymentRepository extends CrudRepository<UserPayment, Long> {

}
