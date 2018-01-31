package com.clps.demo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.clps.demo.domain.Account;
import com.clps.demo.domain.Inventory;
import com.clps.demo.domain.Lineitem;
import com.clps.demo.domain.Orders;
import com.clps.demo.domain.Orderstatus;

/**
 * 用户订单的DAO层
 * @author 苗云春
 *
 */
public interface IOrderDao {
	
	/**
	 * 通过userid查询Account
	 * @param userid
	 * @return
	 */
	public Account queryAccount(String userid);
	
	/**
	 * 保存Orders
	 * @param orders
	 */
	public void saveOrder(Orders orders);
	
	/**
	 * 保存Lineitem
	 * @param lineitem
	 */
	public void saveLineitem(Lineitem lineitem);
	
	/**
	 * 保存Orderstatus
	 * @param orderstatus
	 */
	public void saveOrderstatus(Orderstatus orderstatus);
	
	/**
	 * 通过userid查询Orders集合
	 * @param userid
	 * @param begin
	 * @param end
	 * @return
	 */
	public List<Orders> queryOrder(String userid,int begin,int end);
	
	/**
	 * 通过orderid查询Orders
	 * @param orderid
	 * @return
	 */
	public Orders queryOrdersOne(long orderid);
	
	/**
	 *查询Inventory集合
	 * @return
	 */
	public List<Inventory> queryInventory();
	
	/**
	 * 更改Inventory
	 * @param inventory
	 */
	public void updateInventory(Inventory inventory);

}
