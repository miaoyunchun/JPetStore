package com.clps.demo.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Account entity.
 * @author 苗云春
 *
 */

public class Account implements java.io.Serializable {


	private String userid;	//主键
	private String email;	//邮箱
	private String firstname;//姓
	private String lastname;//名
	private String status;  //用户状态，默认不需要
	private String addr1;	//地址1
	private String addr2;	//地址2
	private String city;	//城市
	private String state;	//区
	private String zip;		//邮政编码
	private String country; //国籍
	private String phone;	//联系电话
	private Set orderses = new HashSet(0);

	// Constructors

	/** 默认构造器 */
	public Account() {
	}

	/** 无订单构造器 */
	public Account(String userid, String email, String firstname, String lastname, String status, String addr1,
			String addr2, String city, String state, String zip, String country, String phone) {
		this.userid = userid;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
		this.phone = phone;
	}

	/** 全参构造器 */

	public Account(String userid, String email, String firstname, String lastname, String status, String addr1,
			String addr2, String city, String state, String zip, String country, String phone, Set orderses) {
		this.userid = userid;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.status = status;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
		this.phone = phone;
		this.orderses = orderses;
	}

	@Override
	public String toString() {
		return "Account [userid=" + userid + ", email=" + email + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", status=" + status + ", addr1=" + addr1 + ", addr2=" + addr2 + ", city=" + city + ", state=" + state
				+ ", zip=" + zip + ", country=" + country + ", phone=" + phone + ", orderses=" + orderses + "]";
	}

	public String getUserid() {
		return this.userid;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
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

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set orderses) {
		this.orderses = orderses;
	}

}