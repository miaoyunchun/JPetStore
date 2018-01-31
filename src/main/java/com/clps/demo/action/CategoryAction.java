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
 * �û�ҳ��չʾ��Action
 * @author ���ƴ�
 *
 */
@Controller
public class CategoryAction {
	@Autowired
	private CategoryService categoryService;
	
	private Category category;
	private Product product;
	private Item item;
	private List<Product> productlist;//����ĳһ��������༯��
	private List<Item> itemlist;//���ؾ������ĸ�����Ϣ����
	private Long qty;//������Ʒ�Ŀ����
	private String value; //ģ����ѯǰ̨���ص�ֵ
	private int begin = 0;//��ҳ����ʼλ
	private int end = 4;//ÿҳչʾ��������
	
	
	/**
	 * ��ѯĳһ���������
	 * @return
	 */
	public String queryProduce(){
		
		productlist = categoryService.query(category,begin*end,end);
		return "success";
	}
	
	/**
	 * ��ѯ�������ĸ�����Ϣ
	 * @return
	 */
	public String queryItem(){
		
		itemlist = categoryService.queryItem(product.getProductid());
		return "success";
	}
	
	/**
	 * ��ѯ���
	 * @return
	 */
	public String queryQty(){
	
		qty = categoryService.queryInventory(item.getItemid());
		item = categoryService.queryItemTwo(item.getItemid());
		return "success";
	}
	
	/**
	 * ������������֣�ģ����ѯ
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
