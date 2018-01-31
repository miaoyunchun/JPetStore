package com.clps.demo.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Category entity.
 * @author ���ƴ�
 * 
 */

public class Category implements java.io.Serializable {

	

	private String catid;//����
	private String name;//�������
	private String descn;//����ͼƬ
	private Set products = new HashSet(0);//ĳһ�����µ�ȫ������



	/** �չ����� */
	public Category() {
	}

	/** ���������� */
	public Category(String catid) {
		this.catid = catid;
	}

	/** ȫ�ι����� */
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