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
 * �û�ҳ���DAO��
 * @author ���ƴ�
 *
 */
public interface ICategoryDao {
	
	/**
	 * ͨ��Category�����������Product
	 * @param category
	 * @param begin
	 * @param end
	 * @return
	 */
	public List<Product> query(Category category, int begin,int end);

	/**
	 * ͨ������produceID��ѯ���������Item
	 * @param produceID
	 * @return
	 */
	public List<Item> queryItem(String produceID);

	/**
	 * ͨ������itemid��ѯItem
	 * @param itemid
	 * @return
	 */
	public Item queryItemTwo(String itemid);

	/**
	 * ��Product�в�ѯname����descn����value�ļ���
	 * @param value
	 * @param begin
	 * @param end
	 * @return
	 */
	public List<Product> queryLike(String value, int begin, int end);

	/**
	 * ͨ��userid��ѯProfile
	 * @param userid
	 * @return
	 */
	public Profile queryProfile(String userid);

	/**
	 * ͨ��itemid��ѯ�����
	 * @param itemid
	 * @return
	 */
	public long queryInventory(String itemid);

}
