package com.tiger.utils.cipher;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import com.tiger.utils.radix.HexUtil;


/**
 * 工具类，提供了生成或者比较HMAC-SHA1签名的一般方法
 * <p/>
 * <p><b>User:</b> charles.wang <a href="mailto:charles.wang0@pactera.com">charles.wang0@pactera.com</a></p>
 * <p><b>Date:</b> 2015-01-06 </p>
 *
 * @author charles.wang
 */
public class HMacSHA1Util {
	
	private HMacSHA1Util(){}

	/**
	 * HMAC加密
	 * @param value
	 * @param key
	 * @return
	 */
    public static String hmacSha1(String value, String key) {
        try {
            // Get an hmac_sha1 key from the raw key bytes
            byte[] keyBytes = key.getBytes();
            SecretKeySpec signingKey = new SecretKeySpec(keyBytes, "HmacSHA1");

            // Get an hmac_sha1 Mac instance and initialize with the signing key
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(signingKey);

            // Compute the hmac on input data bytes
            byte[] rawHmac = mac.doFinal(value.getBytes());

            // Convert raw bytes to Hex
            String hexBytes =HexUtil.byte2hex(rawHmac);
            return hexBytes;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * 拼接参数字符串：“先将参数按照a-z排序,再将参数和值(key=value)用&拼接起来”
     * @param map： map.put("client_id", client_id)...
     * @return string
     */
    public static String spliceParam(Map<String, String> map){
		String result="";
		if(map.size()>0){
			java.util.List<String> paramsort = new ArrayList<String>();
			Set<Entry<String, String>> entrySet = map.entrySet();
			for (Entry<String, String> entry : entrySet) {
				String key = entry.getKey();
				paramsort.add(key);
			}
			
			StringBuffer paramBf = new StringBuffer();
			if(paramsort.size()>0){
				Collections.sort(paramsort);
				//将排序后的参数(key=value)用&拼接起来，并进行URL编码。
				//$data = a=x&b=y&c=z  ……   $data = urlencode($data);
				int flag=0;
				for (String str : paramsort) {
					paramBf.append(str+"="+map.get(str));
					flag++;
					if(flag!=paramsort.size()){
						paramBf.append("&");
					}
				}
			}
			result = paramBf.toString();
		}
		return result;
	}
    
    /**
     * HMAC签名，用于确定消息的不可篡改性
     * @param encryptText  加密的文本字符串
     * @param encryptKey 用于签名的macKey
     * @return 签名结果字符串（Base64)
     */
    public static String hmacSHA1Encrypt(String encryptText,String encryptKey) {
    	
    	try{
    		//构建密钥
    		byte[] data=encryptKey.getBytes("UTF-8");  
    		
    		//根据给定的字节数组构造一个密钥,第二参数指定一个密钥算法的名称  
    		SecretKey secretKey = new SecretKeySpec(data, "HmacSHA1"); 
    		
    		//生成一个指定 Mac 算法 的 Mac 对象  
    		Mac mac = Mac.getInstance("HmacSHA1");   
    		//用给定密钥初始化 Mac 对象  
    		mac.init(secretKey);    
    		
    		//构建文本
    		byte[] text = encryptText.getBytes("UTF-8");    
    		
    		//完成 Mac 操作 ，获得 HMAC签名
    		byte[] result =  mac.doFinal(text); 
    		
    		//吧byte[]转为hexDigest
    		return byteArrayToHexString(result).toUpperCase();
    		
    	}catch(UnsupportedEncodingException ex){
    		ex.printStackTrace();
    		return null;
    	}catch(InvalidKeyException ex){
    		ex.printStackTrace();
    		return null;
    	}catch(NoSuchAlgorithmException ex){
    		ex.printStackTrace();
    		return null;
    	}
       
    }
    
    /**
     * 初始化macKey
     * @return 字符串形式的macKey
     * @throws Exception
     */
    public static String initMacKey() {  
    	
    	try{
    		KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA1");  
  
    		SecretKey secretKey = keyGenerator.generateKey();  
    		return Base64.encodeBase64String(secretKey.getEncoded());  
    	}catch(NoSuchAlgorithmException ex){
    		ex.printStackTrace();
    		return null;
    	}
    	
    }  

    /**
     *  byteArrayToHexString
     * @param b  The byteArray 
     * @return HexString Encoded string  
     */
    private static String byteArrayToHexString(byte[] b) {
        int len = b.length;
        String data = new String();
        for (int i = 0; i < len; i++) {
            data += Integer.toHexString((b[i] >> 4) & 0xf);
            data += Integer.toHexString(b[i] & 0xf);
        }
        return data;
    }

}
