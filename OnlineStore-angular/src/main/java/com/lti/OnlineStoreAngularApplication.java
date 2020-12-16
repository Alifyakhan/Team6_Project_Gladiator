package com.lti;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lti.config.SecurityUtility;
import com.lti.domain.UserT;
import com.lti.security.Role;
import com.lti.security.UserRole;
import com.lti.service.UserService;


@SpringBootApplication
public class OnlineStoreAngularApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(OnlineStoreAngularApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
	
		UserT user1 = new UserT();
		user1.setFirstName("admin");
		user1.setLastName("admin");
		user1.setUsername("admin");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user1.setEmail("alifyak126@gmail.com");
		user1.setPhone("9967769487");
		Set<UserRole> userRoles = new HashSet<>();
		Role role1 = new Role();
		//role1.setRoleId(1);
		role1.setName("ROLE_USER");
		userRoles.add(new UserRole(user1, role1));
		
		userService.createUser(user1, userRoles);
		userRoles.clear();
		
		UserT user2 = new UserT();
		user2.setFirstName("Retailer");
		user2.setLastName("Retailer");
		user2.setUsername("retailer");
		user2.setPassword(SecurityUtility.passwordEncoder().encode("r"));
		user2.setEmail("alifya.khan@lntinfotech.com");
		user2.setPhone("9757379171");
		Role role2 = new Role();
		//role2.setRoleId(0);
		role2.setName("ROLE_RETAILER");
		userRoles.add(new UserRole(user2, role2));
		
		userService.createUser(user2, userRoles);
		userRoles.clear();
		
		UserT user3 = new UserT();
		user3.setFirstName("Reena");
		user3.setLastName("Mohi");
		user3.setUsername("Rii");
		user3.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user3.setEmail("Reena@gmail.com");
		Role role3= new Role();
		//role2.setRoleId(0);
		role3.setName("ROLE_USER");
		userRoles.add(new UserRole(user3,role3));
		
		userService.createUser(user3,userRoles);
		
		
	}
	

}
