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
 * �û�������DAO��
 * @author ���ƴ�
 *
 */
public interface IOrderDao {
	
	/**
	 * ͨ��userid��ѯAccount
	 * @param userid
	 * @return
	 */
	public Account queryAccount(String userid);
	
	/**
	 * ����Orders
	 * @param orders
	 */
	public void saveOrder(Orders orders);
	
	/**
	 * ����Lineitem
	 * @param lineitem
	 */
	public void saveLineitem(Lineitem lineitem);
	
	/**
	 * ����Orderstatus
	 * @param orderstatus
	 */
	public void saveOrderstatus(Orderstatus orderstatus);
	
	/**
	 * ͨ��userid��ѯOrders����
	 * @param userid
	 * @param begin
	 * @param end
	 * @return
	 */
	public List<Orders> queryOrder(String userid,int begin,int end);
	
	/**
	 * ͨ��orderid��ѯOrders
	 * @param orderid
	 * @return
	 */
	public Orders queryOrdersOne(long orderid);
	
	/**
	 *��ѯInventory����
	 * @return
	 */
	public List<Inventory> queryInventory();
	
	/**
	 * ����Inventory
	 * @param inventory
	 */
	public void updateInventory(Inventory inventory);

}
