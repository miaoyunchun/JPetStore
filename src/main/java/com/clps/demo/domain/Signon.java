package com.clps.demo.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Signon entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Signon implements java.io.Serializable {

	// Fields

	private String userid;//用户名
	private String password;//密码
	private Set carts = new HashSet(0);//对应多个购物车

	// Constructors

	/** default constructor */
	public Signon() {
	}

	/** minimal constructor */
	public Signon(String userid, String password) {
		this.userid = userid;
		this.password = password;
	}

	/** full constructor */
	public Signon(String userid, String password, Set carts) {
		this.userid = userid;
		this.password = password;
		this.carts = carts;
	}

	// Property accessors

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set getCarts() {
		return this.carts;
	}

	public void setCarts(Set carts) {
		this.carts = carts;
	}

}