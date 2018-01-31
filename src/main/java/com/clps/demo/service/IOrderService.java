package com.clps.demo.service;

import java.util.List;

import com.clps.demo.domain.Account;
import com.clps.demo.domain.Inventory;
import com.clps.demo.domain.Lineitem;
import com.clps.demo.domain.Orders;
import com.clps.demo.domain.Orderstatus;

/**
 * �û�������ҵ���߼���
 * 
 * @author ���ƴ�
 *
 */
public interface IOrderService {
	
	/**
	 * ͨ���û�����ѯAccount
	 * @param userid
	 * @return
	 */
	public Account queryAccount(String userid);
	
	/**
	 * ���涩��Orders
	 * @param orders
	 */
	public void saveOrders(Orders orders);
	
	/**
	 * ���湺����Lineitem
	 * @param lineitem
	 */
	public void saveLineitem(Lineitem lineitem);
	
	/**
	 * ���涩��״̬Orderstatus
	 * @param orderstatus
	 */
	public void saveOrderstatus(Orderstatus Orderstatus);
	
	/**
	 * ͨ���û�����ѯ���û����ж���
	 * @param userid
	 * @param begin
	 * @param end
	 * @return
	 */
	public List<Orders> queryOrder(String userid,int begin,int end);
	
	/**
	 * ��ѯ���ù�����Ŀ��
	 * @return
	 */
	public List<Inventory> queryInventory();
	
	/**
	 * ���¿��
	 * @param inventory
	 */
	public void updateInventory(Inventory inventory);
	
	/**
	 * ͨ��������ѯ�ö���
	 * @param orderid
	 * @return
	 */
	public Orders queryOrdersOne(long orderid);

}
