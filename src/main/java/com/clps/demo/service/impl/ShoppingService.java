package com.clps.demo.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.demo.dao.impl.ShoppingDao;
import com.clps.demo.domain.Cart;
import com.clps.demo.service.IShoppingService;


@Service
public class ShoppingService implements IShoppingService{
	@Autowired
	private ShoppingDao shoppingDao;

	public void saveShopping(Cart cart){
		
		shoppingDao.saveShopping(cart);
		
	}
	
	
	
	public List<Cart> queryShopping(String userid){
		
		return shoppingDao.queryShopping(userid);
		
	}
	
	public int deleteShopping(String itemid,String userid){
		
		return shoppingDao.deleteShopping(itemid, userid);
	}
	
	public long updateQuantity(long quantity,String itemid,String userid){
		
		
		return shoppingDao.updateQuantity(quantity, itemid, userid);
	}
	

	public long queryCountShopping(String itemid,String userid){
		
		return shoppingDao.queryCountShopping(itemid, userid);
	}
	
	public Cart queryOneShopping(String userid,String itemid){
		
		
		return shoppingDao.queryOneShopping(userid, itemid);
		
	} 
	
	
	public long count(String itemid,String userid){
		
		return shoppingDao.count(itemid, userid);
		
	}
	
	public ShoppingDao getShoppingDao() {
		return shoppingDao;
	}

	public void setShoppingDao(ShoppingDao shoppingDao) {
		this.shoppingDao = shoppingDao;
	}
	
	
}
