package com.lti.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.domain.CartItem;
import com.lti.domain.Product;
import com.lti.domain.ProductToCartItem;
import com.lti.domain.ShoppingCart;
import com.lti.domain.UserT;
import com.lti.repository.CartItemRepository;
import com.lti.repository.ProductToCartItemRepository;
import com.lti.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService{
	
	@Autowired
	private CartItemRepository cartItemRepository;
	
	@Autowired
	private ProductToCartItemRepository productToCartItemRepository;

	public CartItem addProductToCartItem(Product product, UserT userr, int qty) {
		List<CartItem> cartItemList = findByShoppingCart(userr.getShoppingCart());
		
    for (CartItem cartItem : cartItemList) {
		if (product.getId() == cartItem.getProduct().getId()) {
			cartItem.setQty(cartItem.getQty()+qty);
			cartItem.setSubtotal(new BigDecimal(product.getPrice()).multiply(new BigDecimal(qty)));
			cartItemRepository.save(cartItem);
			return cartItem;
		}
	}
	
	CartItem cartItem = new CartItem();
	cartItem.setShoppingCart(userr.getShoppingCart());
	cartItem.setProduct(product);
	cartItem.setQty(qty);
	cartItem.setSubtotal(new BigDecimal(product.getPrice()).multiply(new BigDecimal(qty)));
	
	cartItem =cartItemRepository.save(cartItem);
	
	ProductToCartItem productToCartItem = new ProductToCartItem();
	productToCartItem.setProduct(product);
	productToCartItem.setCartItem(cartItem);
	productToCartItemRepository.save(productToCartItem);
	
	return cartItem;
}

@Transactional
public void removeCartItem(CartItem cartItem) {
	productToCartItemRepository.deleteByCartItem(cartItem);
	cartItemRepository.delete(cartItem);
}

public List<CartItem> findByShoppingCart(ShoppingCart shoppingCart) {
	return cartItemRepository.findByShoppingCart(shoppingCart);
}

public CartItem updateCartItem(CartItem cartItem) {
	BigDecimal bigDecimal = new BigDecimal(cartItem.getProduct().getPrice()).multiply(new BigDecimal(cartItem.getQty()));
	bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
	cartItem.setSubtotal(bigDecimal);
	
	cartItemRepository.save(cartItem);
	
	return cartItem;
	
}

public CartItem findById(Long id) {
	return cartItemRepository.findById(id).orElse(null);
}

public CartItem save(CartItem cartItem) {
	return cartItemRepository.save(cartItem);
}

//public List<CartItem> findByOrder(Order order) {
//	return cartItemRepository.findByOrder(order);
//}

	}
