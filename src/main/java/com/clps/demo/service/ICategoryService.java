package com.clps.demo.service;

import java.util.List;

import com.clps.demo.domain.Category;
import com.clps.demo.domain.Item;
import com.clps.demo.domain.Product;
import com.clps.demo.domain.Profile;

/**
 * �û�ҳ���ҵ���߼���
 * 
 * @author ���ƴ�
 *
 */
public interface ICategoryService {

	/**
	 * ��ѯĳһ�����嵥
	 * @param category
	 * @param begin
	 * @param end
	 * @return
	 */
	public List<Product> query(Category category, int begin, int end);

	/**
	 * ��ѯ�������ĸ�����Ϣ�嵥
	 * @param produceID
	 * @return
	 */
	public List<Item> queryItem(String produceID);

	/**
	 * ��ѯ�������Ŀ����Ϣ
	 * @param itemid
	 * @return
	 */
	public long queryInventory(String itemid);

	/**
	 * ͨ��itemid��ѯ������Item��Ϣ
	 * @param itemid
	 * @return
	 */
	public Item queryItemTwo(String itemid);

	/**
	 * ��Ʒ������ѯ
	 * @param value
	 * @param begin
	 * @param end
	 * @return
	 */
	public List<Product> queryLike(String value, int begin, int end);

	/**
	 * ��ѯ��¼�û��ĸ�����ϢProfile
	 * @param userid
	 * @return
	 */
	public Profile queryProfile(String userid);

}
