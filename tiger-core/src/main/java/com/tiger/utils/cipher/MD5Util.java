package com.tiger.utils.cipher;

import java.security.MessageDigest;

/**
 * 工具类：提供了MD5加密的一般方法
 * <p/>
 * <p><b>User:</b> charles.wang <a href="mailto:charles.wang0@pactera.com">charles.wang0@pactera.com</a></p>
 * <p><b>Date:</b> 2015-01-06 </p>
 *
 * @author charles.wang
 */
public class MD5Util {
    
    public static final String MD5 = "MD5";

    public static String encrypt(String data) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance(MD5);  
        byte[] byteArray = data.getBytes();
        byte[] md5Bytes = md5.digest(byteArray);  
        StringBuffer hexValue = new StringBuffer();  
        for (int i = 0; i < md5Bytes.length; i++){  
            int val = ((int) md5Bytes[i]) & 0xff;  
            if (val < 16)  
                hexValue.append("0");  
            hexValue.append(Integer.toHexString(val));  
        }  
        return hexValue.toString();
    }
    
}
