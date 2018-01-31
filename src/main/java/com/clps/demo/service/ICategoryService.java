package com.clps.demo.service;

import java.util.List;

import com.clps.demo.domain.Category;
import com.clps.demo.domain.Item;
import com.clps.demo.domain.Product;
import com.clps.demo.domain.Profile;

/**
 * 用户页面的业务逻辑层
 * 
 * @author 苗云春
 *
 */
public interface ICategoryService {

	/**
	 * 查询某一宠物清单
	 * @param category
	 * @param begin
	 * @param end
	 * @return
	 */
	public List<Product> query(Category category, int begin, int end);

	/**
	 * 查询具体宠物的各项信息清单
	 * @param produceID
	 * @return
	 */
	public List<Item> queryItem(String produceID);

	/**
	 * 查询具体宠物的库存信息
	 * @param itemid
	 * @return
	 */
	public long queryInventory(String itemid);

	/**
	 * 通过itemid查询出具体Item信息
	 * @param itemid
	 * @return
	 */
	public Item queryItemTwo(String itemid);

	/**
	 * 商品搜索查询
	 * @param value
	 * @param begin
	 * @param end
	 * @return
	 */
	public List<Product> queryLike(String value, int begin, int end);

	/**
	 * 查询登录用户的辅助信息Profile
	 * @param userid
	 * @return
	 */
	public Profile queryProfile(String userid);

}
