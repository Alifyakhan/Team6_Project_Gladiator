package com.lti.service;

import java.util.Set;

import com.lti.domain.UserBilling;
import com.lti.domain.UserPayment;
import com.lti.domain.UserShipping;
import com.lti.domain.UserT;
import com.lti.security.UserRole;

public interface UserService {
	
	UserT createUser(UserT userr, Set<UserRole> userRoles);
	
	 UserT findByUsername(String username);
		
	UserT findByEmail (String email);
		
	UserT save(UserT userr);
		
	UserT findById(Long id);
	
void updateUserPaymentInfo(UserBilling userBilling, UserPayment userPayment, UserT userr);
	
	void updateUserBilling(UserBilling userBilling, UserPayment userPayment, UserT userr);
	
	void setUserDefaultPayment(Long userPaymentId, UserT userr);
	
	void updateUserShipping(UserShipping userShipping, UserT userr);

	void setUserDefaultShipping(Long userShippingId, UserT userr);

}
