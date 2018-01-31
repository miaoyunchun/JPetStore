package com.clps.demo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.clps.demo.domain.Cart;

/**
 * ���ﳵ��DAO��
 * @author ���ƴ�
 *
 */
public interface IShoppingDao {
	
	/**
	 * ������־û������ݿ�
	 * @param cart
	 */
	public void saveShopping(Cart cart);
	
	/**
	 * �����ݿ��ѯ�������
	 * @param userid
	 * @return
	 */
	public List<Cart> queryShopping(String userid); 
	
	/**
	 * ɾ��ĳ�û��Ĺ�����
	 * @param itemid
	 * @param userid
	 * @return
	 */
	public int deleteShopping(String itemid,String userid);
	
	/**
	 * ����ĳ�û��Ĺ���������
	 * @param quantity
	 * @param itemid
	 * @param userid
	 * @return
	 */
	public long updateQuantity(long quantity,String itemid,String userid);
	
	/**
	 * ���ݿ��в�ѯ�û��Ƿ��д˹�����
	 * @param itemid
	 * @param userid
	 * @return
	 */
	public long queryCountShopping(String itemid,String userid);
	
	/**
	 * ���ݿ��в��ĳ�û��Ĺ�������Ϣ
	 * @param userid
	 * @param itemid
	 * @return
	 */
	public Cart queryOneShopping(String userid,String itemid); 
	
	/**
	 * ���ݿ��в�������������
	 * @param itemid
	 * @param userid
	 * @return
	 */
	public long count(String itemid,String userid);

}
