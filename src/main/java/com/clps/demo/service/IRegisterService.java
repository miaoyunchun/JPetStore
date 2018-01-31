package com.clps.demo.service;

import com.clps.demo.domain.Account;
import com.clps.demo.domain.Profile;
import com.clps.demo.domain.Signon;
/**
 * 用户注册的业务逻辑层
 * @author 苗云春
 *
 */
public interface IRegisterService {
	/**
	 *检测注册时用户名已存在
	 * @param userid
	 * @return
	 */
	public long userRegister(String userid);
	/**
	 * 注册信息插入signon类
	 * @param signon
	 */
	public void insertSigno(Signon signon);
	/**
	 * 注册信息插入profile类
	 * @param profile
	 */	
	public void insertProfile(Profile profile);
	/**
	 * 注册信息插入account类
	 * @param account
	 */
	public void insertAccount(Account account);

}
