package com.clps.demo.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 用户加密类
 * 
 * @author 苗云春
 *
 */
public class EncryptUtil {
	  /**利用MD5进行加密
     * @param str  待加密的字符串
     * @return  加密后的字符串
     * @throws NoSuchAlgorithmException  没有这种产生消息摘要的算法
     * @throws UnsupportedEncodingException  
     */
    public static String EncoderByMd5(String str) {
       
         String newstr="";
		try {
			 //确定计算方法
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			 //加密后的字符串
	        byte[] md5Byte = md5.digest(str.getBytes("utf-8"));
	        newstr = BASE64Encoder(md5Byte);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        return newstr;
    }
   
     // 二进制转十六进制  
    public static String BASE64Encoder(byte[] bytes) {  
        StringBuffer hexStr = new StringBuffer();  
        int num;  
        for (int i = 0; i < bytes.length; i++) {  
            num = bytes[i];  
             if(num < 0) {  
                 num += 256;  
            }  
            if(num < 16){  
                hexStr.append("0");  
            }  
            hexStr.append(Integer.toHexString(num));  
        }  
        return hexStr.toString().toUpperCase();  
    }  

}
