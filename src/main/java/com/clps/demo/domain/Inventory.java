package com.clps.demo.domain;

/**
 * Inventory entity.
 * @author ���ƴ�
 * 
 */

public class Inventory implements java.io.Serializable {

	

	private String itemid;//�������
	private Long qty;//�����

	

	/** �չ����� */
	public Inventory() {
	}

	/** ȫ�ι����� */
	public Inventory(String itemid, Long qty) {
		this.itemid = itemid;
		this.qty = qty;
	}

	

	public String getItemid() {
		return this.itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	public Long getQty() {
		return this.qty;
	}

	public void setQty(Long qty) {
		this.qty = qty;
	}

}