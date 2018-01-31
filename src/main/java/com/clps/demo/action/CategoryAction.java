package com.clps.demo.action;

import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.clps.demo.domain.*;
import com.clps.demo.service.impl.CategoryService;
import com.clps.demo.domain.*;
import com.opensymphony.xwork2.ActionContext;

/**
 * 用户页面展示的Action
 * @author 苗云春
 *
 */
@Controller
public class CategoryAction {
	@Autowired
	private CategoryService categoryService;
	
	private Category category;
	private Product product;
	private Item item;
	private List<Product> productlist;//返回某一宠物的种类集合
	private List<Item> itemlist;//返回具体宠物的各项信息集合
	private Long qty;//返回商品的库存量
	private String value; //模糊查询前台返回的值
	private int begin = 0;//分页的起始位
	private int end = 4;//每页展示的数据量
	
	
	/**
	 * 查询某一宠物的种类
	 * @return
	 */
	public String queryProduce(){
		
		productlist = categoryService.query(category,begin*end,end);
		return "success";
	}
	
	/**
	 * 查询具体宠物的各项信息
	 * @return
	 */
	public String queryItem(){
		
		itemlist = categoryService.queryItem(product.getProductid());
		return "success";
	}
	
	/**
	 * 查询库存
	 * @return
	 */
	public String queryQty(){
	
		qty = categoryService.queryInventory(item.getItemid());
		item = categoryService.queryItemTwo(item.getItemid());
		return "success";
	}
	
	/**
	 * 搜索宠物的名字，模糊查询
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String queryLike() throws UnsupportedEncodingException{
		value = new String(value.getBytes("ISO-8859-1"),"UTF-8");
		productlist = categoryService.queryLike(value,begin*end,end);
		ActionContext.getContext().getSession().put("begin",begin);
		return "success";
		
	}

	@JSON(serialize=false)	
	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	@JSON(serialize=false)
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Product> getProductlist() {
		return productlist;
	}

	public void setProductlist(List<Product> productlist) {
		this.productlist = productlist;
	}
	@JSON(serialize=false)
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	@JSON(serialize=false)
	public List<Item> getItemlist() {
		return itemlist;
	}

	public void setItemlist(List<Item> itemlist) {
		this.itemlist = itemlist;
	}
	@JSON(serialize=false)
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	@JSON(serialize=false)
	public Long getQty() {
		return qty;
	}

	public void setQty(Long qty) {
		this.qty = qty;
	}
	
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	
	
	
	
	
}
