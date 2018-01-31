package com.clps.demo.service;

import java.util.List;

import com.clps.demo.domain.Cart;

/**
 * 购物车的业务逻辑层
 * @author 苗云春
 *
 */
public interface IShoppingService {

	/**
	 * 保存购物项
	 * @param cart
	 */
	public void saveShopping(Cart cart);

	/**
	 * 查询用户的购物车
	 * @param userid
	 * @return
	 */
	public List<Cart> queryShopping(String userid);
	
	/**
	 * 删除某个用户的的购物项
	 * @param itemid
	 * @param userid
	 * @return
	 */
	public int deleteShopping(String itemid,String userid);
	
	/**
	 * 更新用户的购物项数量
	 * @param quantity
	 * @param itemid
	 * @param userid
	 * @return
	 */
	public long updateQuantity(long quantity,String itemid,String userid);
	
	/**
	 * 查询某用户是否含有此购物项
	 * @param itemid
	 * @param userid
	 * @return
	 */
	public long queryCountShopping(String itemid,String userid);
	
	/**
	 * 查询某用户的购物项
	 * @param userid
	 * @param itemid
	 * @return
	 */
	public Cart queryOneShopping(String userid,String itemid); 

	/**
	 * 查询某用户某购物项的数量
	 * @param itemid
	 * @param userid
	 * @return
	 */
	public long count(String itemid,String userid);
}
