package com.clps.demo.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import com.clps.demo.domain.Cart;
import com.clps.demo.domain.Category;
import com.clps.demo.domain.Item;
import com.clps.demo.domain.Product;
import com.clps.demo.domain.Profile;
import com.clps.demo.domain.Signon;
import com.opensymphony.xwork2.ActionContext;
import com.clps.demo.service.impl.CategoryService;
import com.clps.demo.service.impl.ShoppingService;
import com.clps.demo.util.DoubleFormat;

/**
 * 商品购物车的Action类
 * @author 苗云春
 *
 */
@Controller
public class ShoppingAction extends ActionSupport{

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ShoppingService shoppingService;
	
	
	private Category category;
	private Product product;
	private Item item;
	private Long qty;
	private Signon signon;
	private Cart cart;
	private Profile profile;
	
	private List<Cart> listcart;
//	private int begin = 0;
//	private int end = 10;
	private Map<String,Integer> itemCountMap; 
	private Map<String,Item> itemMap;
	private List<Product> productlist;
	private Map<String, Long> itemQtyMap;
	
	int result=0;//添加购物车的结果
//	int qtyResult=0;//库存结果，0表示没有1表示有
	double total=0.0;//购物车总价
	Map<String, Double> saveCountMap = new HashMap<>();//改变购物数量返回集合给json解析
	int deleteResult=0;//删除购物项的结果
//	String warn;
	
	
	/**
	 * 加入购物车
	 * @return
	 */
	public String saveShopping(){
		
		//未登录用户 ：itemlist-购物项清单  cartMap-购物清单数  itemMap-购物单详细信息
		if("null".equals(signon.getUserid())||signon.getUserid()==""||signon.getUserid()==null){
			
			qty = categoryService.queryInventory(item.getItemid());
			if (qty<=0) {
				return "success";
			}
			if (itemQtyMap==null) {
				itemQtyMap = new HashMap<>();
			}
			
			itemQtyMap.put(item.getItemid(), qty);
			ActionContext.getContext().getSession().put("qtyMap",itemQtyMap);
			//------------------------------------------------
			// Itemid - Count 
			itemCountMap = (Map<String, Integer>) ActionContext.getContext().getSession().get("itemCountMap");
			// Itemid - Item
			itemMap = (Map<String, Item>) ActionContext.getContext().getSession().get("itemMap");
			if(itemCountMap == null){
				
				itemCountMap = new HashMap<String, Integer>();
			}
			if(itemMap == null){
				itemMap = new HashMap<String, Item>();
			}
			
			item = categoryService.queryItemTwo(item.getItemid());
			//未登录购物项的添加-----有错
			if(itemMap.containsKey(item.getItemid())){
			
				itemCountMap.put(item.getItemid(), itemCountMap.get(item.getItemid())+1);
				item.setCount(itemCountMap.get(item.getItemid()));
				
			}else{
				itemCountMap.put(item.getItemid(), 1);
			
				item.setCount(1);
			
			}
			ActionContext.getContext().getSession().put("itemCountMap",itemCountMap);
			itemMap.put(item.getItemid(), item);
			ActionContext.getContext().getSession().put("itemMap",itemMap);
			if (qty>0) {
				result=1;
			}
		}else{
			//登录用户
			qty = categoryService.queryInventory(item.getItemid());
			if (qty<=0) {
				return "success";
			}
			item = categoryService.queryItemTwo(item.getItemid());
			if(shoppingService.queryCountShopping(item.getItemid(), signon.getUserid()) > 0){
				cart = shoppingService.queryOneShopping(signon.getUserid(), item.getItemid());			
				shoppingService.updateQuantity(cart.getQuantity().intValue() + 1, item.getItemid(), signon.getUserid());
			}else{		
				cart = new Cart();
				long id=System.currentTimeMillis();
				cart.setId(id);
				cart.setItem(item);
				cart.setSignon(signon);
				cart.setQuantity((long)1);
				shoppingService.saveShopping(cart);			

			}	
			if (qty>0) {
				result=1;
			}
		}
		
		return "success";
	}
	
	/**
	 * 删除用户购物车项
	 * @return
	 */
	
	public String deleteShoppingItem(){
		
		
		if("null".equals(signon.getUserid())||signon.getUserid()==""||signon.getUserid()==null){
			
			Map<String,Item> itemMap = (Map<String, Item>) ActionContext.getContext().getSession().get("itemMap");
		
			itemMap.remove(item.getItemid());
			ActionContext.getContext().getSession().put("itemMap", itemMap);
			deleteResult=1;
			return "success";
			
			
		}else{
			
			int result = shoppingService.deleteShopping(item.getItemid(), signon.getUserid());
			deleteResult=1;
			if(result > 0){
				
				return "success";
			}else{
				
				return "error";
			}
		}
		
	}
	
	/**
	 * 查询库存放入session
	 * @return
	 */
	public String selectqty() {	
			qty = categoryService.queryInventory(item.getItemid());
			itemQtyMap.put(item.getItemid(), qty);
			ActionContext.getContext().getSession().put("qtyMap2",itemQtyMap);

		return "success";
		
	}
	
	/**
	 * 查询购物车
	 * @return
	 */
	public String queryShopping(){
		if("null".equals(signon.getUserid())||signon.getUserid()==""||signon.getUserid()==null){
			itemMap = (Map<String, Item>) ActionContext.getContext().getSession().get("itemMap");
			if (itemMap!=null) {
			for (Map.Entry<String, Item> entry: itemMap.entrySet()) {
				Item item = entry.getValue();
				double listprice = item.getListprice();
				double sumprice = listprice*item.getCount();
				total+=sumprice;
				
			}
			total=DoubleFormat.parseDouble(total);
			}
			return "success";
		}else {
			category = new Category();
			profile = categoryService.queryProfile(signon.getUserid());		
			category.setCatid(	profile.getFavcategory());
//			category.setCatid("CATS");
			productlist = categoryService.query(category,0,10);			
			listcart = shoppingService.queryShopping(signon.getUserid());	
			for (Cart cart : listcart) {
//				long qtyNum = categoryService.queryInventory(cart.getItem().getItemid());
//				if (qtyNum<cart.getQuantity()) {
//					warn="商品 ："+cart.getItem().getItemid()+"的最大库存数为"+cart.getQuantity();
//					return "success";
//				}
				double listprice = cart.getItem().getListprice()*cart.getQuantity();
				total+=listprice;
			}
			total=DoubleFormat.parseDouble(total);
		return "success";
		}
	}
	/**
	 * 查询库存是否充足，充足且保存
	 * @return
	 */
	public String saveCount(){
		double qtyResult=0.0;
		if("null".equals(signon.getUserid())||signon.getUserid()==""||signon.getUserid()==null){
			
			//查询item库存
			long number = categoryService.queryInventory(item.getItemid());
			if (item.getCount()>number) {
				saveCountMap.put("qtyResult",qtyResult );
				return "success";
			}
			itemMap = (Map<String, Item>) ActionContext.getContext().getSession().get("itemMap");		
			Item item2 = itemMap.get(item.getItemid());
			item2.setCount(item.getCount());
			itemMap.put(item2.getItemid(),item2);
			for (Map.Entry<String, Item> entry: itemMap.entrySet()) {
				Item item = entry.getValue();
				double listprice = item.getListprice();
				double sumprice = listprice*item.getCount();
				total+=sumprice;
			}
			ActionContext.getContext().getSession().put("itemMap",itemMap);
			qtyResult=1.0;
			saveCountMap.put("qtyResult",qtyResult );
			total=DoubleFormat.parseDouble(total);
			saveCountMap.put("total", total);
		}else{
			long number = categoryService.queryInventory(item.getItemid());
			if (item.getCount()>number) {
				saveCountMap.put("qtyResult",qtyResult );
				return "success";
			}
			shoppingService.updateQuantity(item.getCount(), item.getItemid(), signon.getUserid());
			
			listcart = shoppingService.queryShopping(signon.getUserid());	
			for (Cart cart : listcart) {
				double listprice = cart.getItem().getListprice()*cart.getQuantity();
				total+=listprice;
			}
			qtyResult=1.0;
			saveCountMap.put("qtyResult",qtyResult );
			total=DoubleFormat.parseDouble(total);
			saveCountMap.put("total", total);
			return "success";
		}
		return "success";
	}
	
	
	@JSON(serialize=false)
	public CategoryService getCategoryService() {
		return categoryService;
	}
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Long getQty() {
		return qty;
	}
	public void setQty(Long qty) {
		this.qty = qty;
	}

	
//	public int getQtyResult() {
//		return qtyResult;
//	}
//
//	public void setQtyResult(int qtyResult) {
//		this.qtyResult = qtyResult;
//	}

	
	public int getDeleteResult() {
		return deleteResult;
	}

	public void setDeleteResult(int deleteResult) {
		this.deleteResult = deleteResult;
	}

	public Map<String, Double> getSaveCountMap() {
		return saveCountMap;
	}

	public void setSaveCountMap(Map<String, Double> saveCountMap) {
		this.saveCountMap = saveCountMap;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public Signon getSignon() {
		return signon;
	}

	public void setSignon(Signon signon) {
		this.signon = signon;
	}
	@JSON(serialize=false)
	public ShoppingService getShoppingService() {
		return shoppingService;
	}

	public void setShoppingService(ShoppingService shoppingService) {
		this.shoppingService = shoppingService;
	}
	@JSON(serialize=false)
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	@JSON(serialize=false)
	public Map<String, Long> getItemQtyMap() {
		return itemQtyMap;
	}

	public void setItemQtyMap(Map<String, Long> itemQtyMap) {
		this.itemQtyMap = itemQtyMap;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@JSON(serialize=false)
	public List<Cart> getListcart() {
		return listcart;
	}

	public void setListcart(List<Cart> listcart) {
		this.listcart = listcart;
	}
	@JSON(serialize=false)
	public Map<String, Integer> getItemCountMap() {
		return itemCountMap;
	}
	
	public void setItemCountMap(Map<String, Integer> itemCountMap) {
		this.itemCountMap =itemCountMap;
	}
	
	public Map<String, Item> getItemMap() {
		return itemMap;
	}

	public void setItemMap(Map<String, Item> itemMap) {
		this.itemMap = itemMap;
	}

	
//	public int getBegin() {
//		return begin;
//	}
//
//	public void setBegin(int begin) {
//		this.begin = begin;
//	}
//
//	public int getEnd() {
//		return end;
//	}
//
//	public void setEnd(int end) {
//		this.end = end;
//	}

	public List<Product> getProductlist() {
		return productlist;
	}

	public void setProductlist(List<Product> productlist) {
		this.productlist = productlist;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	
	
	
	
	
	
}
