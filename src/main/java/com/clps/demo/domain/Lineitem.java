package com.clps.demo.domain;

/**
 * Lineitem entity.
 * @author 苗云春
 * 
 */

public class Lineitem implements java.io.Serializable {

	

	private LineitemId id;//生成订单的购物项
	private Long quantity;//数量
	private Double unitprice;//成本

	

	/** 无参构造器 */
	public Lineitem() {
	}

	/** 全参构造器 */
	public Lineitem(LineitemId id, Long quantity, Double unitprice) {
		this.id = id;
		this.quantity = quantity;
		this.unitprice = unitprice;
	}

	

	public LineitemId getId() {
		return this.id;
	}

	public void setId(LineitemId id) {
		this.id = id;
	}

	public Long getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Double getUnitprice() {
		return this.unitprice;
	}

	public void setUnitprice(Double unitprice) {
		this.unitprice = unitprice;
	}

}