package com.lti.service;

import java.util.List;

import com.lti.domain.CartItem;
import com.lti.domain.Product;
import com.lti.domain.ShoppingCart;
import com.lti.domain.UserT;

public interface CartItemService {

	CartItem addProductToCartItem(Product product, UserT userr, int qty);
	
	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);
	
//	List<CartItem> findByOrder(Order order);
	
	CartItem updateCartItem(CartItem cartItem);
	
	void removeCartItem(CartItem cartItem);
	
	CartItem findById(Long id);
	
	CartItem save(CartItem cartItem);
}
