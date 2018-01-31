package com.clps.demo.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.clps.demo.domain.Account;
import com.clps.demo.domain.Profile;
import com.clps.demo.domain.Signon;
import com.clps.demo.util.EncryptUtil;

/**
 * 用户登录的DAO层
 * @author 苗云春
 *
 */
public interface ILoginDao {
	/**
	 * 通过用户名、密码到数据库查找用户
	 * @param userid
	 * @param password
	 * @return
	 */
	public long userLogin(String userid,String password);
	
	/**
	 * 查询用户的email是否正确
	 * @param userid
	 * @param email
	 * @return
	 */
	public long selectEmail(String userid,String email);

	/**
	 * 更改用户密码
	 * @param userid
	 * @param password
	 * @return
	 */
	public long updatePassword(String userid,String password);
	
	/**
	 * 通过用户名查找Signon
	 * @param userid
	 * @return
	 */
	public Signon querySignon(String userid);
	
	/**
	 * 通过用户名查找Account
	 * @param userid
	 * @return
	 */
	public Account queryAccount(String userid);
	
	/**
	 * 通过用户名查找Profile
	 * @param userid
	 * @return
	 */
	public Profile queryProfile(String userid);
	
	/**
	 * 将Profile,Account信息持久化到数据库
	 * @param profile
	 * @param account
	 */
	public void saveUserInfomation(Profile profile,Account account);	

}
