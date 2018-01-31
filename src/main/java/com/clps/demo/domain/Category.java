package com.clps.demo.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Category entity.
 * @author 苗云春
 * 
 */

public class Category implements java.io.Serializable {

	

	private String catid;//主键
	private String name;//宠物类别
	private String descn;//宠物图片
	private Set products = new HashSet(0);//某一宠物下的全部种类



	/** 空构造器 */
	public Category() {
	}

	/** 主键构造器 */
	public Category(String catid) {
		this.catid = catid;
	}

	/** 全参构造器 */
	public Category(String catid, String name, String descn, Set products) {
		this.catid = catid;
		this.name = name;
		this.descn = descn;
		this.products = products;
	}

	

	public String getCatid() {
		return this.catid;
	}

	public void setCatid(String catid) {
		this.catid = catid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescn() {
		return this.descn;
	}

	public void setDescn(String descn) {
		this.descn = descn;
	}

	public Set getProducts() {
		return this.products;
	}

	public void setProducts(Set products) {
		this.products = products;
	}

}