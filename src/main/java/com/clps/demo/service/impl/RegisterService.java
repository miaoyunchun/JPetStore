package com.clps.demo.service.impl;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.demo.dao.impl.RegisterDao;
import com.clps.demo.domain.Account;
import com.clps.demo.domain.Profile;
import com.clps.demo.domain.Signon;
import com.clps.demo.service.IRegisterService;

@Service
public class RegisterService implements IRegisterService{
	@Autowired
	private RegisterDao registerDao;
	
	public long userRegister(String userid){
		return registerDao.userRegister(userid);
	}

	public void insertSigno(Signon signon){
		registerDao.insertSigno(signon);
	}
	
	public void insertProfile(Profile profile){
		registerDao.insertProfile(profile);
		
		
	}
	
	public void insertAccount(Account account){
		registerDao.insertAccount(account);
		
	}
	
	
	public RegisterDao getRegisterDao() {
		return registerDao;
	}

	public void setRegisterDao(RegisterDao registerDao) {
		this.registerDao = registerDao;
	}
	
	
}
