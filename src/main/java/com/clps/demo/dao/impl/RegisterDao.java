package com.clps.demo.dao.impl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clps.demo.dao.IRegisterDao;
import com.clps.demo.domain.Account;
import com.clps.demo.domain.Profile;
import com.clps.demo.domain.Signon;


@Repository
public class RegisterDao implements IRegisterDao{
	@Autowired
	private SessionFactory sessionFactory;

	public long userRegister(String userid){	
		Session session = sessionFactory.openSession();
		String hql = "SELECT COUNT(*) FROM Account WHERE userid = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, userid);
		long result = (long)query.uniqueResult();
		session.close();
		return result;
	}
	public void insertSigno(Signon signon){
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(signon);
		tr.commit();
		session.close();
	}
	
	public void insertProfile(Profile profile){
		
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(profile);
		
		tr.commit();
		session.close();
		
	}
	
	public void insertAccount(Account account){
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(account);
		
		tr.commit();
		session.close();
		
	}
}
