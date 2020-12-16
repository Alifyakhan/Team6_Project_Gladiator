package com.lti.resource;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.domain.UserShipping;
import com.lti.domain.UserT;
import com.lti.service.UserService;
import com.lti.service.UserShippingService;


@RestController
@RequestMapping("/shipping")
public class ShippingResource {
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserShippingService userShippingService;
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ResponseEntity addNewUserShippingPost(
			@RequestBody UserShipping userShipping, Principal principal
			) {
		UserT userr = userService.findByUsername(principal.getName());
		userService.updateUserShipping(userShipping, userr);
		
		return new ResponseEntity("Shipping Added(Updated) Successfully!", HttpStatus.OK);
	}
	
	@RequestMapping("/getUserShippingList")
	public List<UserShipping> getUserShippingList(
			Principal principal
			){
		UserT userr = userService.findByUsername(principal.getName());
		List<UserShipping> userShippingList = userr.getUserShippingList();
		
		return userShippingList;
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public ResponseEntity removeUserShippingPost(
			@RequestBody String id,
			Principal principal
			) {
		userShippingService.removeById(Long.parseLong(id));
		return new ResponseEntity("Shipping Removed Successfully!", HttpStatus.OK);
	}
	
	@RequestMapping(value="/setDefault", method=RequestMethod.POST)
	public ResponseEntity setDefaultUserShippingPost(
			@RequestBody String id, Principal principal
			){
		UserT userr = userService.findByUsername(principal.getName());
		userService.setUserDefaultShipping(Long.parseLong(id), userr);
		
		return new ResponseEntity("Set Default Shipping Successfully!", HttpStatus.OK);
	}
}
