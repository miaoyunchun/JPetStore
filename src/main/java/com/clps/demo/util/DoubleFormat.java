package com.clps.demo.util;

import java.math.BigDecimal;
/**
 * Double类型保存俩位有效数字
 * 
 * @author 苗云春
 *
 */
public class DoubleFormat {
	
	/**
	 * 
	 * @param 传入的数字：number
	 * @return 保留俩位有效数的结果
	 */
	public static double parseDouble(double number) {
//		String format = new java.text.DecimalFormat("#.00").format(number);
//		return format;
		 BigDecimal bg = new BigDecimal(number);    
         double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();    
		 return f1;    
		
	}

}
