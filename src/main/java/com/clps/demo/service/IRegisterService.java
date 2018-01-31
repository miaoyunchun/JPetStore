package com.clps.demo.service;

import com.clps.demo.domain.Account;
import com.clps.demo.domain.Profile;
import com.clps.demo.domain.Signon;
/**
 * �û�ע���ҵ���߼���
 * @author ���ƴ�
 *
 */
public interface IRegisterService {
	/**
	 *���ע��ʱ�û����Ѵ���
	 * @param userid
	 * @return
	 */
	public long userRegister(String userid);
	/**
	 * ע����Ϣ����signon��
	 * @param signon
	 */
	public void insertSigno(Signon signon);
	/**
	 * ע����Ϣ����profile��
	 * @param profile
	 */	
	public void insertProfile(Profile profile);
	/**
	 * ע����Ϣ����account��
	 * @param account
	 */
	public void insertAccount(Account account);

}
