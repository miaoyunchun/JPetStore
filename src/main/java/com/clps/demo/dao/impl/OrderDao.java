package com.clps.demo.dao.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clps.demo.domain.*;

@Repository
public class OrderDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Account queryAccount(String userid){
		
		Session session = sessionFactory.openSession();
		
		Account account = (Account) session.get(Account.class, userid);
		
		session.close();
		return account;
	}
	
	public void saveOrder(Orders orders){
		
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		/*Orders order = new Orders();
		order.setAccount(account);
		order.setOrderstatuses(orderstatus);
		order.setLineitems(lineitems);*/
		
		session.save(orders);
		

		tr.commit();
		session.close();
		
		
	}
	
	public void saveLineitem(Lineitem lineitem){
		
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();

		
		
		session.save(lineitem);

		tr.commit();
		session.close();
		
		
	}
	
	public void saveOrderstatus(Orderstatus orderstatus){
		
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();

		
		
		session.save(orderstatus);

		tr.commit();
		session.close();
		
		
	}
	
	public List<Orders> queryOrder(String userid,int begin,int end){
		
		Session session = sessionFactory.openSession();
		String hql="FROM Orders WHERE userid = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, userid);
		query.setFirstResult(begin);
		query.setMaxResults(end);
		List<Orders> orderslist = query.list();
		
		session.close();
		return orderslist;
		
	}
	
	public Orders queryOrdersOne(long orderid){
		Session session = sessionFactory.openSession();
		Orders orders = (Orders) session.get(Orders.class, orderid);
		
		session.close();
		return orders;
		
	}
	
	public List<Inventory> queryInventory(){
		
		Session session = sessionFactory.openSession();
		String hql="FROM Inventory";
		Query query = session.createQuery(hql);
		List<Inventory> inventorylist = query.list();
		session.close();
		return inventorylist;
		
	}
	
	public void updateInventory(Inventory inventory){
		
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		
		session.update(inventory);
		
		tr.commit();
		session.close();
	}
	
	
}
