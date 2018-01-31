package com.clps.demo.action;

import java.util.ArrayList;
import java.util.List;

import java.util.Map;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.clps.demo.domain.*;
import com.clps.demo.service.impl.LoginService;
import com.clps.demo.service.impl.ShoppingService;
import com.clps.demo.util.EncryptUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.sun.org.apache.xml.internal.utils.IntVector;

/**
 * �û���¼�Լ��û���Ϣ��action��
 * @author ���ƴ�
 *
 */
@Controller
public class LoginAction extends ActionSupport{

	@Autowired
	private LoginService loginService;
	@Autowired
	private ShoppingService shoppingService;
	
	private Signon signon;
	private Profile profile;
	private Account account;
	private long result;//�û���¼�Ľ��
	private Map<String,Item> itemMap;
	private long forgetPasswordResult;//�������뷵�صĽ��
	private long updatePasswordRresult;//�������뷵�صĽ��
//	private int begin = 0;
//	private int end = 10;
	
	
	/**
	 * �û���¼ִ�з�������ȡ��½ǰ���ﳵ����itemMap�����¼�û��������ﳵ��Ϣ��
	 * ���¹��ﳵ��Ϣ�����º�ɾ��δ��¼���湺���е���Ϣ
	 * @return
	 */
	public String login(){
		result = loginService.userLogin(signon.getUserid(),signon.getPassword());
		ActionContext.getContext().getSession().put("userid",signon.getUserid());
		//���ݿ�������
		if(result > 0){
			//δ��¼����Ĺ�����
			if(ActionContext.getContext().getSession().get("itemMap")!=null){				
				itemMap = (Map<String, Item>) ActionContext.getContext().getSession().get("itemMap");
				List<Cart> cartlist = shoppingService.queryShopping(signon.getUserid());
				Cart cart = new Cart();
				Set<String> set = itemMap.keySet();
				for(String s : set){					
					cart.setItem(itemMap.get(s));
					if(cartlist.contains(cart)){
						long count = itemMap.get(s).getCount() + shoppingService.count(s, signon.getUserid());
						shoppingService.updateQuantity(count, s, signon.getUserid());
					}else{
						long id=System.currentTimeMillis();
						List<Long> cartid = new ArrayList<>();
						for (Cart cart2 : cartlist) {
							cartid.add(cart2.getId());
						}
						if (!cartid.contains(id)) {
							cart.setId(id);
							cart.setSignon(signon);
							cart.setQuantity((long)itemMap.get(s).getCount());
							shoppingService.saveShopping(cart);
						}						
					}
				}
				
				ActionContext.getContext().getSession().remove("itemMap");
			}
			
		}
		return "success";
		
	}
	
	/**
	 * ��ѯ�û���Ϣ������ǰ̨��ʾ
	 * @return
	 */
	public String queryInfoByUser(){
		signon = loginService.querySignon(signon.getUserid());
		profile = loginService.queryProfile(signon.getUserid());
		account = loginService.queryAccount(signon.getUserid());
		return "success";
	}
	
	/**
	 * �޸��û���Ϣ�ķ���
	 * @return
	 */
	public String saveUserInfomation(){
		String userid = (String) ActionContext.getContext().getSession().get("userid");
		profile.setUserid(userid);
		account.setUserid(userid);
		loginService.saveUserInfomation(profile, account);
		return "success";
	}
	
	/**
	 * �û��ǳ�ɾ��session�е�userid
	 * @return
	 */
	public String drop(){
		ActionContext.getContext().getSession().remove("userid");
		return "success";	
	} 
	
	/**
	 * ��������
	 * @return
	 */
	public String forgetPassword() {		
		String userid=signon.getUserid();
		forgetPasswordResult = loginService.selectEmail(signon.getUserid(), account.getEmail());
		return "success";
	}
	
	/**
	 * ��������
	 * @return
	 */
	public String updatePassword() {
		String password = EncryptUtil.EncoderByMd5(signon.getPassword());
		updatePasswordRresult=loginService.updatePassword(signon.getUserid(), password);
		return "success";
	}
	
	@JSON(serialize=false)
	public ShoppingService getShoppingService() {
		return shoppingService;
	}
	public void setShoppingService(ShoppingService shoppingService) {
		this.shoppingService = shoppingService;
	}
	
	@JSON(serialize=false)
	public Map<String, Item> getItemMap() {
		return itemMap;
	}
	public void setItemMap(Map<String, Item> itemMap) {
		this.itemMap = itemMap;
	}
	
	@JSON(serialize=false)
	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	
	public Signon getSignon() {
		return signon;
	} 

	public void setSignon(Signon signon) {
		this.signon = signon;
	}

	
	public long getForgetPasswordResult() {
		return forgetPasswordResult;
	}

	public void setForgetPasswordResult(long forgetPasswordResult) {
		this.forgetPasswordResult = forgetPasswordResult;
	}

	public long getUpdatePasswordRresult() {
		return updatePasswordRresult;
	}

	public void setUpdatePasswordRresult(long updatePasswordRresult) {
		this.updatePasswordRresult = updatePasswordRresult;
	}

	public long getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
	
	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	
	public Account getAccount() {
		return account;
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}
	
//	public int getBegin() {
//		return begin;
//	}
//	public void setBegin(int begin) {
//		this.begin = begin;
//	}
//	public int getEnd() {
//		return end;
//	}
//	public void setEnd(int end) {
//		this.end = end;
//	}
	
}
