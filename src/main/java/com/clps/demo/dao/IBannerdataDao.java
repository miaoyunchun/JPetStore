package com.clps.demo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.clps.demo.domain.Bannerdata;
import com.clps.demo.domain.Profile;

/**
 * 用户辅助信息的DAO层
 * @author 苗云春
 *
 */
public interface IBannerdataDao {
	
	/**
	 * 通过userid到数据库查询Bannerdata
	 * @param userid
	 * @return
	 */
	public Bannerdata querybanner(String userid);
	
	/**
	 * 通过userid到数据库查询Profile
	 * @param userid
	 * @return
	 */
	public Profile queryMyListOpf(String userid);
	
	/**
	 * 通过userid到数据库查询Profile
	 * @param userid
	 * @return
	 */
	public Profile queryMyList(String userid);

}
