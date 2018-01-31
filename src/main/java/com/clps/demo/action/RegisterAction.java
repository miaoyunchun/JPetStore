package com.clps.demo.action;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.clps.demo.domain.*;
import com.clps.demo.service.impl.RegisterService;
import com.clps.demo.util.EncryptUtil;

/**
 * �û�ע���action��
 * @author ���ƴ�
 *
 */
@Controller
public class RegisterAction {

	@Autowired
	private RegisterService registerService;
	
	private Account account;
	private Profile profile;
	private Signon signon;
	
	private long status;//�û������ڵı�־λ

	/**
	 * ���ע���û����Ƿ����
	 * @return
	 */
	public String checkUsername(){
		if (signon.getUserid()!=null ||"".equals(signon.getUserid())) {
			
			status = registerService.userRegister(signon.getUserid());
			if ("null".equals(signon.getUserid())) {
				status=-1;
			}
		}
		return "success";
		
	}
	/**
	 * ע��ʱ�����ݳ־û�
	 * @return
	 */
	public String insert(){
		String password = EncryptUtil.EncoderByMd5(signon.getPassword());
		signon.setPassword(password);
		if(profile.getBanneropt() == null){		
			profile.setBanneropt((long)0);
		}
		if(profile.getMylistopt() == null){
			profile.setMylistopt((long)0);
		}
		profile.setUserid(signon.getUserid());	
		account.setUserid(signon.getUserid());
		registerService.insertAccount(account);
		registerService.insertProfile(profile);
		registerService.insertSigno(signon);
			
		return "success";
	}
	
	
	@JSON(serialize=false)
	public RegisterService getRegisterService() {
		return registerService;
	}

	public void setRegisterService(RegisterService registerService) {
		this.registerService = registerService;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Signon getSignon() {
		return signon;
	}

	public void setSignon(Signon signon) {
		this.signon = signon;
	}
	public long getStatus() {
		return status;
	}
	public void setStatus(long status) {
		this.status = status;
	}
	
	
	
	
	
	
}
