package com.clps.demo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.clps.demo.domain.Cart;

/**
 * 购物车的DAO层
 * @author 苗云春
 *
 */
public interface IShoppingDao {
	
	/**
	 * 购物项持久化到数据库
	 * @param cart
	 */
	public void saveShopping(Cart cart);
	
	/**
	 * 到数据库查询数据项集合
	 * @param userid
	 * @return
	 */
	public List<Cart> queryShopping(String userid); 
	
	/**
	 * 删除某用户的购物项
	 * @param itemid
	 * @param userid
	 * @return
	 */
	public int deleteShopping(String itemid,String userid);
	
	/**
	 * 更新某用户的购物项数量
	 * @param quantity
	 * @param itemid
	 * @param userid
	 * @return
	 */
	public long updateQuantity(long quantity,String itemid,String userid);
	
	/**
	 * 数据库中查询用户是否含有此购物项
	 * @param itemid
	 * @param userid
	 * @return
	 */
	public long queryCountShopping(String itemid,String userid);
	
	/**
	 * 数据库中查出某用户的购物项信息
	 * @param userid
	 * @param itemid
	 * @return
	 */
	public Cart queryOneShopping(String userid,String itemid); 
	
	/**
	 * 数据库中查出购物项的数量
	 * @param itemid
	 * @param userid
	 * @return
	 */
	public long count(String itemid,String userid);

}
