package com.clps.demo.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Supplier entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Supplier implements java.io.Serializable {

	// Fields

	private Long suppid;//主键
	private String name;//商家名
	private String status;//AC
	private String addr1;//地址
	private String city;//城市
	private String state;//CA
	private String zip;//94024
	private String phone;//手机
	private Set items = new HashSet(0);//对应多个购物项

	// Constructors

	/** default constructor */
	public Supplier() {
	}

	/** minimal constructor */
	public Supplier(Long suppid, String status) {
		this.suppid = suppid;
		this.status = status;
	}

	/** full constructor */
	public Supplier(Long suppid, String name, String status, String addr1,
			String city, String state, String zip, String phone, Set items) {
		this.suppid = suppid;
		this.name = name;
		this.status = status;
		this.addr1 = addr1;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.items = items;
	}

	// Property accessors

	public Long getSuppid() {
		return this.suppid;
	}

	public void setSuppid(Long suppid) {
		this.suppid = suppid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddr1() {
		return this.addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set getItems() {
		return this.items;
	}

	public void setItems(Set items) {
		this.items = items;
	}

}