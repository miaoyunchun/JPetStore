package com.clps.demo.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Item entity.
 * @author 苗云春
 * 
 */

public class Item implements java.io.Serializable {

	

	private String itemid;//具体宠物名
	private Supplier supplier;//出售宠物的商家类
	private Product product;//宠物的类别
	private Double listprice;//单价
	private Double unitcost;//成本
	private String status;//状态，一般不需要
	private String attr1;//介绍
	private String attr2;
	private String attr3;
	private String attr4;
	private String attr5;
	private Set carts = new HashSet(0);//对应的购物项
	private int count;//用户未登录时，用于计算宠物项的数量
	
	

	/** 空构造器 */
	public Item() {
	}

	
	public Item(String itemid, Product product) {
		this.itemid = itemid;
		this.product = product;
	}

	/** 全参构造器 */
	public Item(String itemid, Supplier supplier, Product product,
			Double listprice, Double unitcost, String status, String attr1,
			String attr2, String attr3, String attr4, String attr5, Set carts) {
		this.itemid = itemid;
		this.supplier = supplier;
		this.product = product;
		this.listprice = listprice;
		this.unitcost = unitcost;
		this.status = status;
		this.attr1 = attr1;
		this.attr2 = attr2;
		this.attr3 = attr3;
		this.attr4 = attr4;
		this.attr5 = attr5;
		this.carts = carts;
	}

	

	public String getItemid() {
		return this.itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Double getListprice() {
		return this.listprice;
	}

	public void setListprice(Double listprice) {
		this.listprice = listprice;
	}

	public Double getUnitcost() {
		return this.unitcost;
	}

	public void setUnitcost(Double unitcost) {
		this.unitcost = unitcost;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAttr1() {
		return this.attr1;
	}

	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}

	public String getAttr2() {
		return this.attr2;
	}

	public void setAttr2(String attr2) {
		this.attr2 = attr2;
	}

	public String getAttr3() {
		return this.attr3;
	}

	public void setAttr3(String attr3) {
		this.attr3 = attr3;
	}

	public String getAttr4() {
		return this.attr4;
	}

	public void setAttr4(String attr4) {
		this.attr4 = attr4;
	}

	public String getAttr5() {
		return this.attr5;
	}

	public void setAttr5(String attr5) {
		this.attr5 = attr5;
	}

	public Set getCarts() {
		return this.carts;
	}

	public void setCarts(Set carts) {
		this.carts = carts;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	

	
	
}