package com.clps.demo.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clps.demo.domain.Account;
import com.clps.demo.domain.Profile;
import com.clps.demo.domain.Signon;
import com.clps.demo.util.EncryptUtil;
import com.clps.demo.*;
import com.clps.demo.dao.ILoginDao;

@Repository
public class LoginDao implements ILoginDao{
	@Autowired
	private SessionFactory sessionFactory;

	public long userLogin(String userid,String password){
		
		Session session = sessionFactory.openSession();	
		String hql = "SELECT COUNT(*) FROM Signon WHERE userid = ? AND password = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, userid);
		query.setParameter(1, EncryptUtil.EncoderByMd5(password));
		long result = (long)query.uniqueResult();
		session.close();
		return result;
	}
	
	public long selectEmail(String userid,String email){
		
		Session session = sessionFactory.openSession();	
		String hql = "SELECT COUNT(*) FROM Account WHERE userid = ? AND email = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, userid);
		query.setParameter(1, email);
		long result = (long)query.uniqueResult();
		session.close();
		return result;
	}

	public long updatePassword(String userid,String password){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();	
		String hql = "UPDATE Signon SET password = ? WHERE  userid=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, password);
		query.setParameter(1, userid);
		long result = query.executeUpdate();		
		tx.commit();
		session.close();
		return result;	
	}
	
	public Signon querySignon(String userid){
		
		Session session = sessionFactory.openSession();	
		Signon signon = (Signon) session.get(Signon.class, userid);	
		session.close();
		return signon;	
	}
	public Account queryAccount(String userid){
		
		Session session = sessionFactory.openSession();		
		Account account = (Account) session.get(Account.class, userid);				
		session.close();
		return account;		
	}
	public Profile queryProfile(String userid){
		
		Session session = sessionFactory.openSession();		
		Profile profile = (Profile) session.get(Profile.class, userid);				
		session.close();
		return profile;		
	}
	
	public void saveUserInfomation(Profile profile,Account account){
		
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();		
		session.update(profile);
		session.update(account);
		tr.commit();
		session.close();
	}	
}
