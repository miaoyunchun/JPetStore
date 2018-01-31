package com.clps.demo.service.impl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.demo.domain.Account;
import com.clps.demo.domain.Profile;
import com.clps.demo.domain.Signon;
import com.clps.demo.service.ILoginService;
import com.clps.demo.dao.*;
import com.clps.demo.dao.impl.LoginDao;

@Service
public class LoginService implements ILoginService{
	@Autowired
	private LoginDao loginDao;

	public long userLogin(String userid,String password){
		
		return loginDao.userLogin(userid, password);
		
	}
	
	public long selectEmail(String userid,String email) {
		
		return loginDao.selectEmail(userid, email);
		
	}
	
	public long updatePassword(String userid,String password){
		
		return loginDao.updatePassword(userid, password);
	}
	
	public Signon querySignon(String userid){
		
		
		return loginDao.querySignon(userid);
		
	}
	public Account queryAccount(String userid){
		
	
		return loginDao.queryAccount(userid);
		
	}
	public Profile queryProfile(String userid){
		
		
		return loginDao.queryProfile(userid);
		
	}
	
	public void saveUserInfomation(Profile profile,Account account){
		
		loginDao.saveUserInfomation(profile, account);
	}
	
	
	
	
	
	
	
	public LoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	
	
	
}
