package com.clps.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import com.clps.demo.domain.Category;
import com.clps.demo.domain.Inventory;
import com.clps.demo.domain.Item;
import com.clps.demo.domain.Product;
import com.clps.demo.domain.Profile;

/**
 * 用户页面的DAO层
 * @author 苗云春
 *
 */
public interface ICategoryDao {
	
	/**
	 * 通过Category查出宠物种类Product
	 * @param category
	 * @param begin
	 * @param end
	 * @return
	 */
	public List<Product> query(Category category, int begin,int end);

	/**
	 * 通过宠物produceID查询具体宠物项Item
	 * @param produceID
	 * @return
	 */
	public List<Item> queryItem(String produceID);

	/**
	 * 通过主键itemid查询Item
	 * @param itemid
	 * @return
	 */
	public Item queryItemTwo(String itemid);

	/**
	 * 从Product中查询name或者descn含有value的集合
	 * @param value
	 * @param begin
	 * @param end
	 * @return
	 */
	public List<Product> queryLike(String value, int begin, int end);

	/**
	 * 通过userid查询Profile
	 * @param userid
	 * @return
	 */
	public Profile queryProfile(String userid);

	/**
	 * 通过itemid查询存货数
	 * @param itemid
	 * @return
	 */
	public long queryInventory(String itemid);

}
