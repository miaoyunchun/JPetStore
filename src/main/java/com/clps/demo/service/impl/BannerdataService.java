package com.clps.demo.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.demo.dao.impl.BannerdataDao;
import com.clps.demo.domain.Bannerdata;
import com.clps.demo.domain.Profile;
import com.clps.demo.service.IBannerdataService;

@Service
public class BannerdataService implements IBannerdataService{

	@Autowired
	private BannerdataDao bannerdataDao;
	
	
	
	public Bannerdata querybanner(String userid){
		
		return bannerdataDao.querybanner(userid);		
	}
	
	
	public Profile queryMyListOpf(String userid){
		
		return bannerdataDao.queryMyListOpf(userid);
	}
	
	public Profile queryMyList(String userid){

		return bannerdataDao.queryMyList(userid);
	}
	
	
	
	
	
	
	
	
	public BannerdataDao getBannerdataDao() {
		return bannerdataDao;
	}

	public void setBannerdataDao(BannerdataDao bannerdataDao) {
		this.bannerdataDao = bannerdataDao;
	}
	
	
}
