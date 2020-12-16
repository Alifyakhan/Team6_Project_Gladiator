package com.lti.repository;

import org.springframework.data.repository.CrudRepository;

import com.lti.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{
	
}
