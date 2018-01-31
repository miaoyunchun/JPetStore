package com.clps.demo.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.clps.demo.domain.Account;
import com.clps.demo.domain.Profile;
import com.clps.demo.domain.Signon;

/**
 * �û�ע���DAO��
 * @author ���ƴ�
 *
 */
public interface IRegisterDao {
	
	/**
	 * �����û��Ƿ����
	 * @param userid
	 * @return
	 */
	public long userRegister(String userid);
	
	/**
	 * ����Signon
	 * @param signon
	 */
	public void insertSigno(Signon signon);
	
	/**
	 * ����Profile
	 * @param profile
	 */
	public void insertProfile(Profile profile);
	
	/**
	 * ����Account
	 * @param account
	 */
	public void insertAccount(Account account);

}
