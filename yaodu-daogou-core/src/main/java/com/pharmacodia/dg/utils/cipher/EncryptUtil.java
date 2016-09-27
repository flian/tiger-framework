package com.pharmacodia.dg.utils.cipher;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * 工具类：提供了加密解密的一般方法
 * <p/>
 * <p><b>User:</b> charles.wang <a href="mailto:charles.wang0@pactera.com">charles.wang0@pactera.com</a></p>
 * <p><b>Date:</b> 2015-01-06 </p>
 *
 * @author charles.wang
 */
public class EncryptUtil {
	
	/**
	 * des加密
	 * @param data
	 * @param key
	 * @param algo
	 * @return
	 * @throws InvalidKeyException
	 * @throws InvalidKeySpecException
	 * @throws NoSuchPaddingException
	 * @throws NoSuchAlgorithmException
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
	 */
	public static byte[] desEncrypt (byte[] data ,byte[] key,String algo)
		    throws InvalidKeyException ,InvalidKeySpecException,NoSuchPaddingException ,NoSuchAlgorithmException,BadPaddingException,IllegalBlockSizeException{
		//构造Key对象
		SecureRandom sr = new SecureRandom();
		SecretKeyFactory keyFactory;
		DESKeySpec dks = new DESKeySpec(key);
		keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = keyFactory.generateSecret(dks);
		
		//实例化Cipher对象用于加密操作
		Cipher cipher = Cipher.getInstance(algo);
		//初始化Cipher对象，表明此Cipher对象正在处于加密模式，并且指定加密用的密钥
		cipher.init(Cipher.ENCRYPT_MODE, secretKey,sr);
		//加密过程，返回加密后的内容
		return cipher.doFinal(data);
	}
	
	
	/**
	 * des解密
	 * @param data
	 * @param key
	 * @param algo
	 * @return
	 * @throws InvalidKeyException
	 * @throws InvalidKeySpecException
	 * @throws NoSuchPaddingException
	 * @throws NoSuchAlgorithmException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public static byte[] desDecrypt(byte[] data,byte[] key,String algo) 
			throws InvalidKeyException,InvalidKeySpecException,NoSuchPaddingException,NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException{
		
		//构造Key对象
		SecureRandom sr = new SecureRandom();
		SecretKeyFactory keyFactory;
		DESKeySpec dks = new DESKeySpec(key);
		keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = keyFactory.generateSecret(dks);
		
		//实例化Cipher对象用于解密操作
		Cipher cipher = Cipher.getInstance(algo);
		//初始化Cipher对象，表明此Cipher对象正在处于解密模式，并且指定解密用的密钥
		cipher.init(Cipher.DECRYPT_MODE, secretKey,sr);
		return cipher.doFinal(data);
				
	}
	

}
