package com.lti.repository;

import org.springframework.data.repository.CrudRepository;

import com.lti.domain.ShoppingCart;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long>{

}