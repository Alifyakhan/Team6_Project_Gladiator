package com.lti.repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;



import com.lti.domain.UserT;

public interface UserRepository extends CrudRepository<UserT, Long>{
	UserT findByUsername(String username);
	UserT findByEmail(String email);
	List<UserT> findAll();
}
