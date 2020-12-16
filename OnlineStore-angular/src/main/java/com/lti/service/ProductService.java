package com.lti.service;

import java.util.List;

import com.lti.domain.Product;

public interface ProductService {
	
	List<Product> findAll();
	
	Product findById(Long id);
	
	Product save(Product product);
	
	List<Product> blurrySearch(String name);
	
	void removeOne(Long id);

}
