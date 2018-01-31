package com.clps.demo.domain;

/**
 * Inventory entity.
 * @author 苗云春
 * 
 */

public class Inventory implements java.io.Serializable {

	

	private String itemid;//库存主键
	private Long qty;//库存数

	

	/** 空构造器 */
	public Inventory() {
	}

	/** 全参构造器 */
	public Inventory(String itemid, Long qty) {
		this.itemid = itemid;
		this.qty = qty;
	}

	

	public String getItemid() {
		return this.itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	public Long getQty() {
		return this.qty;
	}

	public void setQty(Long qty) {
		this.qty = qty;
	}

}