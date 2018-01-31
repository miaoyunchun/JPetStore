package com.clps.demo.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * �û�������
 * 
 * @author ���ƴ�
 *
 */
public class EncryptUtil {
	  /**����MD5���м���
     * @param str  �����ܵ��ַ���
     * @return  ���ܺ���ַ���
     * @throws NoSuchAlgorithmException  û�����ֲ�����ϢժҪ���㷨
     * @throws UnsupportedEncodingException  
     */
    public static String EncoderByMd5(String str) {
       
         String newstr="";
		try {
			 //ȷ�����㷽��
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			 //���ܺ���ַ���
	        byte[] md5Byte = md5.digest(str.getBytes("utf-8"));
	        newstr = BASE64Encoder(md5Byte);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        return newstr;
    }
   
     // ������תʮ������  
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
