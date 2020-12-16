package com.lti.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.domain.Product;
import com.lti.repository.ProductRepository;
import com.lti.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productrepository;
	
	public List<Product> findAll(){
		List<Product> productList = (List<Product>) productrepository.findAll();
		
		List<Product> activeProductList =  new ArrayList<>();
		
		for(Product product : productList) {
			if(product.isActivee()) {
				activeProductList.add(product);
			}
		}
		
		return activeProductList;
	}
	
	public Product findById(Long id) {
		return productrepository.findById(id).orElse(null);
	}
	
	public Product save(Product product) {
		return productrepository.save(product);
	}
	
	public List<Product> blurrySearch(String name){
		List<Product> productList = productrepository.findAll();
		
		List<Product> activeProductList = new ArrayList<>();
		
		for(Product product : productList) {
			if(product.isActivee()) {
				activeProductList.add(product);
			}
		}
		
		return activeProductList;
	}
	
	public void removeOne(Long id) {
		productrepository.deleteById(id);
		
	}

	

}
