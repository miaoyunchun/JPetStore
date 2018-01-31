package com.clps.demo.domain;

/**
 * Lineitem entity.
 * @author ���ƴ�
 * 
 */

public class Lineitem implements java.io.Serializable {

	

	private LineitemId id;//���ɶ����Ĺ�����
	private Long quantity;//����
	private Double unitprice;//�ɱ�

	

	/** �޲ι����� */
	public Lineitem() {
	}

	/** ȫ�ι����� */
	public Lineitem(LineitemId id, Long quantity, Double unitprice) {
		this.id = id;
		this.quantity = quantity;
		this.unitprice = unitprice;
	}

	

	public LineitemId getId() {
		return this.id;
	}

	public void setId(LineitemId id) {
		this.id = id;
	}

	public Long getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Double getUnitprice() {
		return this.unitprice;
	}

	public void setUnitprice(Double unitprice) {
		this.unitprice = unitprice;
	}

}