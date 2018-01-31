package com.clps.demo.action;

import java.util.Date;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.clps.demo.domain.*;
import com.clps.demo.service.impl.OrderService;
import com.clps.demo.service.impl.ShoppingService;

/**
 * 用户订单的Action类
 * @author 苗云春
 *
 */
@Controller
public class OrderAction {
	@Autowired
	private OrderService orderService;
	@Autowired
	private ShoppingService shoppingService;
	
	private Account account;
	private Signon signon;
	private Orders orders;
	private Lineitem lineitem;
	private Orderstatus orserstatus;
	private LineitemId lineitemId;
	private OrderstatusId orderstatusId;
	private List<Cart> cartlist;
	private List<Orders> orderslist;
	private int begin = 0;
	private int end = 4;
	
	/**
	 * 查询用户信息
	 * @return
	 */
	public String queryAccount(){
		account = orderService.queryAccount(signon.getUserid());
		return "success";
	}
	
	/**
	 * 生成订单
	 * @return
	 */
	public String saveOrder(){
//		if (signon.getUserid()==""||signon.getUserid()==null) {
//			return "success";
//		}
		
		account.setUserid(signon.getUserid());
		orders.setAccount(account);
		orders.setOrderid(System.currentTimeMillis());
		orders.setOrderdate(new Date());
		//orders.setShipstate("123");
		//orders.setBillstate("123");
	
		lineitem = new Lineitem();
		lineitemId = new LineitemId();
		lineitemId.setOrders(orders);
		
		cartlist = shoppingService.queryShopping(signon.getUserid());
		double sum = 0;
		
		for(Cart cart2 : cartlist){
			double price = cart2.getItem().getListprice();
			long count = cart2.getQuantity();
			sum = sum + price * count;
			
		}
		
		orders.setTotalprice(sum);
		
		orderService.saveOrders(orders);
		
		for(Cart cart : cartlist){
			
			lineitemId.setItemid(cart.getItem().getItemid());
			lineitem.setQuantity(cart.getQuantity());
			lineitem.setUnitprice(cart.getItem().getListprice());
			lineitem.setId(lineitemId);
			orderService.saveLineitem(lineitem);
		}
		
		
		orserstatus = new Orderstatus();
		orderstatusId = new OrderstatusId();
		orderstatusId.setOrders(orders);
		orderstatusId.setLinenum((long)1);
		orserstatus.setId(orderstatusId);
		orserstatus.setTimestamp(orders.getOrderdate());
		orserstatus.setStatus("p");
		orderService.saveOrderstatus(orserstatus);
		
		List<Inventory> inventorylist = orderService.queryInventory();
		for(Cart cart3 : cartlist){
			
			for(Inventory i:inventorylist){
				
				if(i.getItemid().equals(cart3.getItem().getItemid())){
					
					i.setQty(i.getQty()-cart3.getQuantity());
					orderService.updateInventory(i);
				}
			}
			
		}
		
		
		return "success";
	}
	
	/**
	 * 查询用户信息，购物项，订单
	 * @return
	 */
	public String queryOrders(){
		account = orderService.queryAccount(signon.getUserid());
		cartlist = shoppingService.queryShopping(signon.getUserid());
		orders = orderService.queryOrdersOne(orders.getOrderid());
		return "success";
	}
	
	/**
	 * 查询用户的历史订单
	 * @return
	 */
	public String historyOrders(){
		
		orderslist = orderService.queryOrder(signon.getUserid(),begin*end,end);
		return "success";
	}
	
	@JSON(serialize=false)
	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public Signon getSignon() {
		return signon;
	}

	public void setSignon(Signon signon) {
		this.signon = signon;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Lineitem getLineitem() {
		return lineitem;
	}

	public void setLineitem(Lineitem lineitem) {
		this.lineitem = lineitem;
	}

	public Orderstatus getOrserstatus() {
		return orserstatus;
	}

	public void setOrserstatus(Orderstatus orserstatus) {
		this.orserstatus = orserstatus;
	}
	@JSON(serialize=false)
	public ShoppingService getShoppingService() {
		return shoppingService;
	}

	public void setShoppingService(ShoppingService shoppingService) {
		this.shoppingService = shoppingService;
	}

	public LineitemId getLineitemId() {
		return lineitemId;
	}

	public void setLineitemId(LineitemId lineitemId) {
		this.lineitemId = lineitemId;
	}

	public OrderstatusId getOrderstatusId() {
		return orderstatusId;
	}

	public void setOrderstatusId(OrderstatusId orderstatusId) {
		this.orderstatusId = orderstatusId;
	}

	public List<Cart> getCartlist() {
		return cartlist;
	}

	public void setCartlist(List<Cart> cartlist) {
		this.cartlist = cartlist;
	}

	public List<Orders> getOrderslist() {
		return orderslist;
	}

	public void setOrderslist(List<Orders> orderslist) {
		this.orderslist = orderslist;
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
