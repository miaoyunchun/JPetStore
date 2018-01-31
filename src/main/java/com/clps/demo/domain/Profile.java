package com.clps.demo.domain;

/**
 * Profile entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Profile implements java.io.Serializable {

	// Fields

	private String userid;//用户名
	private String langpref;//语言
	private String favcategory;//喜欢的宠物
	private Long mylistopt;//广告
	private Long banneropt;

	// Constructors

	/** default constructor */
	public Profile() {
	}

	/** minimal constructor */
	public Profile(String userid, String langpref) {
		this.userid = userid;
		this.langpref = langpref;
	}

	/** full constructor */
	public Profile(String userid, String langpref, String favcategory,
			Long mylistopt, Long banneropt) {
		this.userid = userid;
		this.langpref = langpref;
		this.favcategory = favcategory;
		this.mylistopt = mylistopt;
		this.banneropt = banneropt;
	}

	@Override
	public String toString() {
		return "Profile [userid=" + userid + ", langpref=" + langpref + ", favcategory=" + favcategory + ", mylistopt="
				+ mylistopt + ", banneropt=" + banneropt + "]";
	}
	
	// Property accessors

	

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getLangpref() {
		return this.langpref;
	}

	public void setLangpref(String langpref) {
		this.langpref = langpref;
	}

	public String getFavcategory() {
		return this.favcategory;
	}

	public void setFavcategory(String favcategory) {
		this.favcategory = favcategory;
	}

	public Long getMylistopt() {
		return this.mylistopt;
	}

	public void setMylistopt(Long mylistopt) {
		this.mylistopt = mylistopt;
	}

	public Long getBanneropt() {
		return this.banneropt;
	}

	public void setBanneropt(Long banneropt) {
		this.banneropt = banneropt;
	}

}