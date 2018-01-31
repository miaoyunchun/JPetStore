package com.clps.demo.domain;

import org.apache.struts2.json.annotations.JSON;

/**
 * Cart entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Cart implements java.io.Serializable {

	// Fields

	private Long id;
	private Item item;
	private Signon signon;
	private Long quantity;

	// Constructors

	/** default constructor */
	public Cart() {
	}

	/** minimal constructor */
	public Cart(Long id, Item item) {
		this.id = id;
		this.item = item;
	}

	/** full constructor */
	public Cart(Long id, Item item, Signon signon, Long quantity) {
		this.id = id;
		this.item = item;
		this.signon = signon;
		this.quantity = quantity;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Signon getSignon() {
		return this.signon;
	}

	public void setSignon(Signon signon) {
		this.signon = signon;
	}

	public Long getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Cart)) {
			return false;
		}
		Cart cart = (Cart)obj;
		
		if(item.getItemid().equals(cart.getItem().getItemid())){
			
			return true;
		}else{
			
			return false;
		}
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode() + 1;
	}
	
	

}