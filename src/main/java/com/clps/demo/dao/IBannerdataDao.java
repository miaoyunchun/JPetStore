package com.clps.demo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.clps.demo.domain.Bannerdata;
import com.clps.demo.domain.Profile;

/**
 * �û�������Ϣ��DAO��
 * @author ���ƴ�
 *
 */
public interface IBannerdataDao {
	
	/**
	 * ͨ��userid�����ݿ��ѯBannerdata
	 * @param userid
	 * @return
	 */
	public Bannerdata querybanner(String userid);
	
	/**
	 * ͨ��userid�����ݿ��ѯProfile
	 * @param userid
	 * @return
	 */
	public Profile queryMyListOpf(String userid);
	
	/**
	 * ͨ��userid�����ݿ��ѯProfile
	 * @param userid
	 * @return
	 */
	public Profile queryMyList(String userid);

}
