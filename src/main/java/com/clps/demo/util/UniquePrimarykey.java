package com.clps.demo.util;

import com.opensymphony.xwork2.ActionContext;

/**
 * ����Ψһ������
 * 
 * @author ���ƴ�
 *
 */
public class UniquePrimarykey {
	
	/**
	 * 
	 * @return ����ֵΪSting���͵�Ψһ������
	 */
	public static String parseString() {
		String userid = (String) ActionContext.getContext().getSession().get("userid");
		long index = System.currentTimeMillis();
		if (userid==null || userid=="") {
			return index+"null";
		}
		else {
		return index+userid;
		}
	}
	
	/**
	 * 
	 * @return ����ֵΪlong���͵�Ψһ������
	 */
	public static long parseInt() {
		return System.currentTimeMillis();
	}

}
