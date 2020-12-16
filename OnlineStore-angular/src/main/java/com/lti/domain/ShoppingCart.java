package com.lti.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@SequenceGenerator(name = "seq10", sequenceName = "seq10", allocationSize = 1)
public class ShoppingCart implements Serializable {
	
	private static final long serialVersionUID = -891273432L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq10")
	private Long id;
	private BigDecimal GrandTotal;
	
	@OneToMany(mappedBy = "shoppingCart", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JsonIgnore
	private List<CartItem>  cartItemList;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private UserT userr;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getGrandTotal() {
		return GrandTotal;
	}

	public void setGrandTotal(BigDecimal grandTotal) {
		GrandTotal = grandTotal;
	}

	public List<CartItem> getCartItemList() {
		return cartItemList;
	}

	public void setCartItemList(List<CartItem> cartItemList) {
		this.cartItemList = cartItemList;
	}

	public UserT getUserr() {
		return userr;
	}

	public void setUserr(UserT userr) {
		this.userr = userr;
	}
	
	
	
}
