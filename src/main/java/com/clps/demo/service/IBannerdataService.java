package com.clps.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.demo.dao.impl.BannerdataDao;
import com.clps.demo.domain.Bannerdata;
import com.clps.demo.domain.Profile;

/**
 * 用户辅助信息的业务逻辑层
 * 
 * @author 苗云春
 *
 */
public interface IBannerdataService {

	/**
	 * 通过userid 查出Bannerdata
	 * @param userid
	 * @return
	 */
	public Bannerdata querybanner(String userid);
	
	
	/**
	 * 通过userid查出Profile
	 * @param userid
	 * @return
	 */
	public Profile queryMyListOpf(String userid);
	
	/**
	 * 通过userid查出Profile
	 * @param userid
	 * @return
	 */
	public Profile queryMyList(String userid);	
	
}
