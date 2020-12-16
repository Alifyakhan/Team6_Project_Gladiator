package com.lti.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lti.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

	List<Product> findAll();	
	
}
