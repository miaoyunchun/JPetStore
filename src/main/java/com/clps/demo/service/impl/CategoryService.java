package com.clps.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.demo.dao.impl.CategoryDao;
import com.clps.demo.domain.*;
import com.clps.demo.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService{
	@Autowired
	private CategoryDao categoryDao;

	
	
	public List<Product> query(Category category,int begin,int end){
		
		return categoryDao.query(category, begin,end);
	}
	
	public List<Item> queryItem(String produceID){
		
		return categoryDao.queryItem(produceID);
	}
	
	public long queryInventory(String itemid){
		
		return categoryDao.queryInventory(itemid);
	}
	
	public Item queryItemTwo(String itemid){
		
		return categoryDao.queryItemTwo(itemid);
	}

	public List<Product> queryLike(String value,int begin,int end){
		
		return categoryDao.queryLike(value,begin,end);
	}
	
	
	public Profile queryProfile(String userid){
		return categoryDao.queryProfile(userid);
		
	}

	
	
	
	
	
	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	
	
}
