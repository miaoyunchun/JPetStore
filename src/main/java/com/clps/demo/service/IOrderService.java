package com.clps.demo.service;

import java.util.List;

import com.clps.demo.domain.Account;
import com.clps.demo.domain.Inventory;
import com.clps.demo.domain.Lineitem;
import com.clps.demo.domain.Orders;
import com.clps.demo.domain.Orderstatus;

/**
 * 用户订单的业务逻辑层
 * 
 * @author 苗云春
 *
 */
public interface IOrderService {
	
	/**
	 * 通过用户名查询Account
	 * @param userid
	 * @return
	 */
	public Account queryAccount(String userid);
	
	/**
	 * 保存订单Orders
	 * @param orders
	 */
	public void saveOrders(Orders orders);
	
	/**
	 * 保存购物项Lineitem
	 * @param lineitem
	 */
	public void saveLineitem(Lineitem lineitem);
	
	/**
	 * 保存订单状态Orderstatus
	 * @param orderstatus
	 */
	public void saveOrderstatus(Orderstatus Orderstatus);
	
	/**
	 * 通过用户名查询该用户所有订单
	 * @param userid
	 * @param begin
	 * @param end
	 * @return
	 */
	public List<Orders> queryOrder(String userid,int begin,int end);
	
	/**
	 * 查询所用购物项的库存
	 * @return
	 */
	public List<Inventory> queryInventory();
	
	/**
	 * 更新库存
	 * @param inventory
	 */
	public void updateInventory(Inventory inventory);
	
	/**
	 * 通过主键查询该订单
	 * @param orderid
	 * @return
	 */
	public Orders queryOrdersOne(long orderid);

}
