package com.lti.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.domain.UserBilling;
import com.lti.domain.UserPayment;
import com.lti.domain.UserShipping;
import com.lti.domain.UserT;
import com.lti.repository.RoleRepository;
import com.lti.repository.UserBillingRepository;
import com.lti.repository.UserPaymentRepository;
import com.lti.repository.UserRepository;
import com.lti.repository.UserShippingRepository;
import com.lti.security.UserRole;
import com.lti.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserBillingRepository userBillingRepository;
	
	@Autowired
	private UserPaymentRepository userPaymentRepository;
	
	@Autowired
	private UserShippingRepository userShippingRepository;
	
	
	@Transactional
	public UserT createUser(UserT userr, Set<UserRole> userRoles) {
		UserT localUser = userRepository.findByUsername(userr.getUsername());
	
	if(localUser != null) {
		LOG.info("User with username {} already exist. Nothing will be done.",userr.getUsername());
	}
	else {
		for(UserRole ur : userRoles) {
			roleRepository.save(ur.getRole());
		}
	
		userr.getUserRoles().addAll(userRoles);
		
		userr.setUserPaymentList(new ArrayList<UserPayment>());
		
		localUser = userRepository.save(userr);
		}
	
		return localUser;
	}
	
	@Override
	public UserT save(UserT userr)  {
		return userRepository.save(userr);
	}
	
	@Override
	public UserT findById(Long id) {
		return  userRepository.findById(id).orElse(null);
	}
	
	@Override
	public UserT findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	@Override
	public UserT findByEmail(String email) {
		return userRepository.findByEmail(email);
	}



	@Override
	public void updateUserPaymentInfo(UserBilling userBilling, UserPayment userPayment, UserT userr) {
		save(userr);
		userBillingRepository.save(userBilling);
		userPaymentRepository.save(userPayment);
	}
	
	@Override
	public void updateUserBilling(UserBilling userBilling, UserPayment userPayment, UserT userr) {
		userPayment.setUserT(userr);
		userPayment.setUserBilling(userBilling);
		userPayment.setDefaultPayment(true);
		userBilling.setUserPayment(userPayment);
		userr.getUserPaymentList().add(userPayment);
		save(userr);
	}
	
	@Override
	public void setUserDefaultPayment(Long userPaymentId, UserT userr) {
		List<UserPayment> userPaymentList = (List<UserPayment>) userPaymentRepository.findAll();
		
		for (UserPayment userPayment : userPaymentList) {
			if(userPayment.getId() == userPaymentId) {
				userPayment.setDefaultPayment(true);
				userPaymentRepository.save(userPayment);
			} else {
				userPayment.setDefaultPayment(false);
				userPaymentRepository.save(userPayment);
			}
		}
	}
	@Override
	public void updateUserShipping(UserShipping userShipping, UserT userr) {
		userShipping.setUserT(userr);
		userShipping.setUserShippingDefault(true);
		userr.getUserShippingList().add(userShipping);
		save(userr);
	}
	
	@Override
	public void setUserDefaultShipping(Long userShippingId, UserT userr) {
		List<UserShipping> userShippingList = (List<UserShipping>) userShippingRepository.findAll();
		
		for (UserShipping userShipping : userShippingList) {
			if(userShipping.getId() == userShippingId) {
				userShipping.setUserShippingDefault(true);
				userShippingRepository.save(userShipping);
			} else {
				userShipping.setUserShippingDefault(false);
				userShippingRepository.save(userShipping);
			}
		}
	}
}
