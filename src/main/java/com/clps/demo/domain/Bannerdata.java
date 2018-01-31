package com.clps.demo.domain;

/**
 * Bannerdata entity.
 *@author 苗云春
 *
 */

public class Bannerdata implements java.io.Serializable {

	

	private String favcategory;//底部页面宠物类型
	private String bannername;//宠物对应的图片路径

	

	/** 空构造器 */
	public Bannerdata() {
	}

	
	public Bannerdata(String favcategory) {
		this.favcategory = favcategory;
	}

	/** 全参构造器 */
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