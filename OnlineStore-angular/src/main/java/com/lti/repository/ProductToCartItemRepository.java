package com.lti.repository;

import org.springframework.data.repository.CrudRepository;

import com.lti.domain.CartItem;
import com.lti.domain.ProductToCartItem;

public interface ProductToCartItemRepository extends CrudRepository<ProductToCartItem, Long>{
   void deleteByCartItem(CartItem cartItem);
   
}
