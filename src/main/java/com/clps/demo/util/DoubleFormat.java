package com.clps.demo.util;

import java.math.BigDecimal;
/**
 * Double���ͱ�����λ��Ч����
 * 
 * @author ���ƴ�
 *
 */
public class DoubleFormat {
	
	/**
	 * 
	 * @param ��������֣�number
	 * @return ������λ��Ч���Ľ��
	 */
	public static double parseDouble(double number) {
//		String format = new java.text.DecimalFormat("#.00").format(number);
//		return format;
		 BigDecimal bg = new BigDecimal(number);    
         double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();    
		 return f1;    
		
	}

}
