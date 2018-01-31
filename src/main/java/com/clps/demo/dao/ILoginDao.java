package com.clps.demo.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.clps.demo.domain.Account;
import com.clps.demo.domain.Profile;
import com.clps.demo.domain.Signon;
import com.clps.demo.util.EncryptUtil;

/**
 * �û���¼��DAO��
 * @author ���ƴ�
 *
 */
public interface ILoginDao {
	/**
	 * ͨ���û��������뵽���ݿ�����û�
	 * @param userid
	 * @param password
	 * @return
	 */
	public long userLogin(String userid,String password);
	
	/**
	 * ��ѯ�û���email�Ƿ���ȷ
	 * @param userid
	 * @param email
	 * @return
	 */
	public long selectEmail(String userid,String email);

	/**
	 * �����û�����
	 * @param userid
	 * @param password
	 * @return
	 */
	public long updatePassword(String userid,String password);
	
	/**
	 * ͨ���û�������Signon
	 * @param userid
	 * @return
	 */
	public Signon querySignon(String userid);
	
	/**
	 * ͨ���û�������Account
	 * @param userid
	 * @return
	 */
	public Account queryAccount(String userid);
	
	/**
	 * ͨ���û�������Profile
	 * @param userid
	 * @return
	 */
	public Profile queryProfile(String userid);
	
	/**
	 * ��Profile,Account��Ϣ�־û������ݿ�
	 * @param profile
	 * @param account
	 */
	public void saveUserInfomation(Profile profile,Account account);	

}
