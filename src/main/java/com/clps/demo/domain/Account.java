package com.clps.demo.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Account entity.
 * @author ���ƴ�
 *
 */

public class Account implements java.io.Serializable {


	private String userid;	//����
	private String email;	//����
	private String firstname;//��
	private String lastname;//��
	private String status;  //�û�״̬��Ĭ�ϲ���Ҫ
	private String addr1;	//��ַ1
	private String addr2;	//��ַ2
	private String city;	//����
	private String state;	//��
	private String zip;		//��������
	private String country; //����
	private String phone;	//��ϵ�绰
	private Set orderses = new HashSet(0);

	// Constructors

	/** Ĭ�Ϲ����� */
	public Account() {
	}

	/** �޶��������� */
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

	/** ȫ�ι����� */

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