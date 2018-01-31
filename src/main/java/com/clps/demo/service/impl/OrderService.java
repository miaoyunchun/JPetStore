package com.clps.demo.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.demo.dao.impl.OrderDao;
import com.clps.demo.domain.Account;
import com.clps.demo.domain.Inventory;
import com.clps.demo.domain.Lineitem;
import com.clps.demo.domain.Orders;
import com.clps.demo.domain.Orderstatus;
import com.clps.demo.service.IOrderService;


@Service
public class OrderService implements IOrderService{
	@Autowired
	private OrderDao orderDao;

	public Account queryAccount(String userid){
		
		return orderDao.queryAccount(userid);
		
	}
	
	public void saveOrders(Orders orders){
		
		orderDao.saveOrder(orders);
		
	}
	
	public void saveLineitem(Lineitem lineitem){
		
		orderDao.saveLineitem(lineitem);
		
	}
	
	public void saveOrderstatus(Orderstatus orderstatus){
		
		orderDao.saveOrderstatus(orderstatus);
		
	}
	
	public List<Orders> queryOrder(String userid,int begin,int end){
		
		return orderDao.queryOrder(userid,begin,end);
		
	}
	
	public List<Inventory> queryInventory(){
		
		
		return orderDao.queryInventory();
		
	}
	
	public void updateInventory(Inventory inventory){
		orderDao.updateInventory(inventory);
	}
	
	
	public Orders queryOrdersOne(long orderid){
		
		return orderDao.queryOrdersOne(orderid);
	}
	
	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
	
}
