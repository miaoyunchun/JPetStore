package com.clps.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.demo.dao.impl.BannerdataDao;
import com.clps.demo.domain.Bannerdata;
import com.clps.demo.domain.Profile;

/**
 * �û�������Ϣ��ҵ���߼���
 * 
 * @author ���ƴ�
 *
 */
public interface IBannerdataService {

	/**
	 * ͨ��userid ���Bannerdata
	 * @param userid
	 * @return
	 */
	public Bannerdata querybanner(String userid);
	
	
	/**
	 * ͨ��userid���Profile
	 * @param userid
	 * @return
	 */
	public Profile queryMyListOpf(String userid);
	
	/**
	 * ͨ��userid���Profile
	 * @param userid
	 * @return
	 */
	public Profile queryMyList(String userid);	
	
}
