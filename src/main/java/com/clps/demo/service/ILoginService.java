package com.clps.demo.service;

import com.clps.demo.dao.impl.LoginDao;
import com.clps.demo.domain.Account;
import com.clps.demo.domain.Profile;
import com.clps.demo.domain.Signon;

/**
 * �û���¼��ҵ���߼���
 * 
 * @author ���ƴ�
 *
 */
public interface ILoginService {

	/**
	 * ��֤�û���������
	 * 
	 * @param userid
	 * @param password
	 * @return
	 */
	public long userLogin(String userid, String password);

	/**
	 * ��ѯ�û���email�Ƿ���ȷ
	 * 
	 * @param userid
	 * @param email
	 * @return
	 */
	public long selectEmail(String userid, String email);

	/**
	 * �����û�����
	 * 
	 * @param userid
	 * @param password
	 * @return
	 */
	public long updatePassword(String userid, String password);

	/**
	 *��ѯ�û���signon��Ϣ
	 * @param userid
	 * @return
	 */
	public Signon querySignon(String userid);

	/**
	 * ��ѯ�û���queryAccount
	 * @param userid
	 * @return
	 */
	public Account queryAccount(String userid);

	/**
	 * ��ѯ�û���Profile
	 * @param userid
	 * @return
	 */
	public Profile queryProfile(String userid);

	/**
	 * �����û�Profie,Account��Ϣ
	 * @param profile
	 * @param account
	 */
	public void saveUserInfomation(Profile profile, Account account);

}
