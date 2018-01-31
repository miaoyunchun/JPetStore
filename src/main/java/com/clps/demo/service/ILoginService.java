package com.clps.demo.service;

import com.clps.demo.dao.impl.LoginDao;
import com.clps.demo.domain.Account;
import com.clps.demo.domain.Profile;
import com.clps.demo.domain.Signon;

/**
 * 用户登录的业务逻辑层
 * 
 * @author 苗云春
 *
 */
public interface ILoginService {

	/**
	 * 验证用户名、密码
	 * 
	 * @param userid
	 * @param password
	 * @return
	 */
	public long userLogin(String userid, String password);

	/**
	 * 查询用户的email是否正确
	 * 
	 * @param userid
	 * @param email
	 * @return
	 */
	public long selectEmail(String userid, String email);

	/**
	 * 更新用户密码
	 * 
	 * @param userid
	 * @param password
	 * @return
	 */
	public long updatePassword(String userid, String password);

	/**
	 *查询用户的signon信息
	 * @param userid
	 * @return
	 */
	public Signon querySignon(String userid);

	/**
	 * 查询用户的queryAccount
	 * @param userid
	 * @return
	 */
	public Account queryAccount(String userid);

	/**
	 * 查询用户的Profile
	 * @param userid
	 * @return
	 */
	public Profile queryProfile(String userid);

	/**
	 * 更改用户Profie,Account信息
	 * @param profile
	 * @param account
	 */
	public void saveUserInfomation(Profile profile, Account account);

}
