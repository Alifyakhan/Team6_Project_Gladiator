package com.lti.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lti.domain.CartItem;
import com.lti.domain.ShoppingCart;

public interface CartItemRepository extends CrudRepository<CartItem, Long>{
	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);

}
