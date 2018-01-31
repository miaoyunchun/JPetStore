package com.clps.demo.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.clps.demo.domain.Account;
import com.clps.demo.domain.Profile;
import com.clps.demo.domain.Signon;

/**
 * 用户注册的DAO层
 * @author 苗云春
 *
 */
public interface IRegisterDao {
	
	/**
	 * 查找用户是否存在
	 * @param userid
	 * @return
	 */
	public long userRegister(String userid);
	
	/**
	 * 保存Signon
	 * @param signon
	 */
	public void insertSigno(Signon signon);
	
	/**
	 * 保存Profile
	 * @param profile
	 */
	public void insertProfile(Profile profile);
	
	/**
	 * 保存Account
	 * @param account
	 */
	public void insertAccount(Account account);

}
