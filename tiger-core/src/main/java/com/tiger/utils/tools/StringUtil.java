package com.tiger.utils.tools;

import com.google.gson.Gson;
import org.apache.commons.lang.ArrayUtils;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 工具类，用于操作字符串
 * <p/>
 * <p><b>User:</b> charles.wang <a href="mailto:charles.wang0@pactera.com">charles.wang0@pactera.com</a></p>
 * <p><b>Date:</b> 2015-01-06 </p>
 *
 * @author charles.wang
 */
public class StringUtil {
	
	private StringUtil(){}

	/**
	 * 16进制数字字符集
	 */
	private static String hexString = "0123456789ABCDEF";

	/*
	 * 将字符串编码成16进制数字,适用于所有字符（包括中文）
	 */
	public static String string2hexString(String str) {
		// 根据默认编码获取字节数组
        try {
            byte[] bytes = str.getBytes("iso-8859-1");
            StringBuilder sb = new StringBuilder(bytes.length * 2);
            // 将字节数组中每个字节拆解成2位16进制整数
            for (int i = 0; i < bytes.length; i++) {
                sb.append(hexString.charAt((bytes[i] & 0xf0) >> 4));
                sb.append(hexString.charAt((bytes[i] & 0x0f) >> 0));
            }
            return sb.toString();
        }
        catch (Exception ex)
        {
            return null;
        }
	}

	/**
	 * 将16进制数字解码成字符串,适用于所有字符（包括中文）
	 */
	public static String hexStringToString(String bytes) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream(
				bytes.length() / 2);
		// 将每2位16进制整数组装成一个字节
		for (int i = 0; i < bytes.length(); i += 2)
			baos.write((hexString.indexOf(bytes.charAt(i)) << 4 | hexString
					.indexOf(bytes.charAt(i + 1))));
		return new String(baos.toByteArray());
	}

    /**
     * 验证字符串是否为空
     */
    public static boolean isNullOrBlank(String str) {
        boolean isOK = false;
        if (str == null || str.trim().length() == 0) {
            isOK = true;
        }
        return isOK;
    }
    
    /**
     * 验证所有的字符串，如果有一个为空，则返回false
     * @param strs  可变长的字符串
     * @return boolean false：至少有一个为空；true：没传或所有都不为空
     * @author kira
     */
    public static boolean checkAllNullOrBlank(String ...strs){
		
		if(ArrayUtils.isEmpty(strs)){
			
			return true;
		}else{
			
			for(int i = 0 ; i < strs.length; i++){
				
				if(StringUtil.isNullOrBlank(strs[i])){
					
					return false;
				}
			}
			return true;
		}
	}
    
 
    
    /**
     * 获取对象的JSON字符串
     */
    public static String getJsonStringFromObject(Object obj) {
        
        String returnString = "";
        if (obj != null) {
            Gson gson = new Gson();
            JSONObject originalJsonObj = new JSONObject(gson.toJson(obj));
            returnString = originalJsonObj.toString();            
        }
        return returnString;
    }
    
    /**
     * 将string转换成list
     * @param sourceStr 需要拆分的字符 
     * @param splitChar 拆分符
     * @return
     */
    public static List<String> stringSwitchList(String sourceStr,String splitChar){
    	
    	List<String> listStr = new ArrayList<String>();
    	if(StringUtil.isNullOrBlank(sourceStr)){
    		
    		return listStr;
    	}
    	
    	String[] strs = sourceStr.split(splitChar);
    	if(ArrayUtils.isEmpty(strs)){
    		return listStr;
    	}
    	
    	listStr = Arrays.asList(strs);
    	return listStr;
    }

    /**
     * 以补0方式格式化字符串
     * @param str 源字符串
     * @param strLength 字符串长度
     * @return
     */
    public static String addZeroForNum(String str, int strLength, boolean isBefore) {
        int strLen = str.length();
        StringBuffer sb = null;
        while (strLen < strLength) {
            sb = new StringBuffer();
            if (isBefore) {
                sb.append("0").append(str);// 左(前)补0
            }
            else {
                sb.append(str).append("0");//右(后)补0
            }
            str = sb.toString();
            strLen = str.length();
        }
        return str;
    }
}
