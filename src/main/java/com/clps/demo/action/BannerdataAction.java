package com.clps.demo.action;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.clps.demo.domain.Bannerdata;
import com.clps.demo.domain.Category;
import com.clps.demo.domain.Product;
import com.clps.demo.domain.Profile;
import com.clps.demo.domain.Signon;
import com.clps.demo.service.impl.BannerdataService;
import com.clps.demo.service.impl.CategoryService;

/**
 * 用户登录动态显示辅助信息的Action
 * @author 苗云春
 *
 */
@Controller
public class BannerdataAction {
	@Autowired
	private BannerdataService bannerdataService;
	@Autowired
	private CategoryService categoryService;
	
	private Bannerdata bannerdata;
	private Signon signon;
	private Profile profile;
	private List<Product> productlist;
	private Product product;
	private Category category;
//	private String result;
	
	/**
	 * 用户登录检索用户注册时选择的动物，在页面下方动态显示
	 * @return
	 */
	public String queryBannerdata(){
		
		if ("null".equals(signon.getUserid()) || signon.getUserid()==null || signon.getUserid()=="") {
			return "error";
		}
		else {		
		bannerdata = bannerdataService.querybanner(signon.getUserid());
		profile = bannerdataService.queryMyListOpf(signon.getUserid());
		return "success";
		
		}
		
	}
	
	/**
	 * 通过用户名查出bannerdata，profile
	 * @return
	 */
	public String queryProduce(){
	
		bannerdata = bannerdataService.querybanner(signon.getUserid());
		profile = bannerdataService.queryMyList(signon.getUserid());
		category = new Category();
		category.setCatid("FISH");
		//productlist = categoryService.query(category,0,10);
		//product = productlist.get(0);
		
		
		return "success";
	}
	
	
	
	@JSON(serialize=false)
	public BannerdataService getBannerdataService() {
		return bannerdataService;
	}

	public void setBannerdataService(BannerdataService bannerdataService) {
		this.bannerdataService = bannerdataService;
	}



	public Bannerdata getBannerdata() {
		return bannerdata;
	}



	public void setBannerdata(Bannerdata bannerdata) {
		this.bannerdata = bannerdata;
	}


	
	@JSON(serialize=false)
	public Signon getSignon() {
		return signon;
	}



	public void setSignon(Signon signon) {
		this.signon = signon;
	}



	public Profile getProfile() {
		return profile;
	}



	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	
	@JSON(serialize=false)
	public CategoryService getCategoryService() {
		return categoryService;
	}
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	@JSON(serialize=false)
	public List<Product> getProductlist() {
		return productlist;
	}
	public void setProductlist(List<Product> productlist) {
		this.productlist = productlist;
	}
	
	@JSON(serialize=false)
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
//	public String getResult() {
//		return result;
//	}
//	public void setResult(String result) {
//		this.result = result;
//	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
	
}
