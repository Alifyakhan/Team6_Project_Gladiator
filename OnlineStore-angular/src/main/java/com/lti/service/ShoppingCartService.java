package com.lti.service;

import com.lti.domain.ShoppingCart;

public interface ShoppingCartService {
ShoppingCart updateShoppingCart(ShoppingCart shoppingCart);
	
	void clearShoppingCart(ShoppingCart shoppingCart);

}
