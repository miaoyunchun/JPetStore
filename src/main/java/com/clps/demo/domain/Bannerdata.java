package com.clps.demo.domain;

/**
 * Bannerdata entity.
 *@author ���ƴ�
 *
 */

public class Bannerdata implements java.io.Serializable {

	

	private String favcategory;//�ײ�ҳ���������
	private String bannername;//�����Ӧ��ͼƬ·��

	

	/** �չ����� */
	public Bannerdata() {
	}

	
	public Bannerdata(String favcategory) {
		this.favcategory = favcategory;
	}

	/** ȫ�ι����� */
	public Bannerdata(String favcategory, String bannername) {
		this.favcategory = favcategory;
		this.bannername = bannername;
	}

	

	public String getFavcategory() {
		return this.favcategory;
	}

	public void setFavcategory(String favcategory) {
		this.favcategory = favcategory;
	}

	public String getBannername() {
		return this.bannername;
	}

	public void setBannername(String bannername) {
		this.bannername = bannername;
	}

}