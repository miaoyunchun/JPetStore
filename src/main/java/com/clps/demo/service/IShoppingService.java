package com.clps.demo.service;

import java.util.List;

import com.clps.demo.domain.Cart;

/**
 * ���ﳵ��ҵ���߼���
 * @author ���ƴ�
 *
 */
public interface IShoppingService {

	/**
	 * ���湺����
	 * @param cart
	 */
	public void saveShopping(Cart cart);

	/**
	 * ��ѯ�û��Ĺ��ﳵ
	 * @param userid
	 * @return
	 */
	public List<Cart> queryShopping(String userid);
	
	/**
	 * ɾ��ĳ���û��ĵĹ�����
	 * @param itemid
	 * @param userid
	 * @return
	 */
	public int deleteShopping(String itemid,String userid);
	
	/**
	 * �����û��Ĺ���������
	 * @param quantity
	 * @param itemid
	 * @param userid
	 * @return
	 */
	public long updateQuantity(long quantity,String itemid,String userid);
	
	/**
	 * ��ѯĳ�û��Ƿ��д˹�����
	 * @param itemid
	 * @param userid
	 * @return
	 */
	public long queryCountShopping(String itemid,String userid);
	
	/**
	 * ��ѯĳ�û��Ĺ�����
	 * @param userid
	 * @param itemid
	 * @return
	 */
	public Cart queryOneShopping(String userid,String itemid); 

	/**
	 * ��ѯĳ�û�ĳ�����������
	 * @param itemid
	 * @param userid
	 * @return
	 */
	public long count(String itemid,String userid);
}
