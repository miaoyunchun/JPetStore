package com.clps.demo.util;

import com.opensymphony.xwork2.ActionContext;

/**
 * 生成唯一性索引
 * 
 * @author 苗云春
 *
 */
public class UniquePrimarykey {
	
	/**
	 * 
	 * @return 返回值为Sting类型的唯一性主键
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
	 * @return 返回值为long类型的唯一性主键
	 */
	public static long parseInt() {
		return System.currentTimeMillis();
	}

}
