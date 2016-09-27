package com.pharmacodia.dg.utils.cipher;


import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.pharmacodia.dg.utils.radix.HexUtil;

/**
 * 工具类，提供了AES加密解密的一般方法
 * <p/>
 * <p><b>User:</b> charles.wang <a href="mailto:charles.wang0@pactera.com">charles.wang0@pactera.com</a></p>
 * <p><b>Date:</b> 2015-01-06 </p>
 *
 * @author charles.wang
 */
public class AESUtil {
    
    public static final String AES = "AES";
    
    public static final String AES_ALGORITHM = "AES/CBC//NoPadding";
    
    private static final String iv = "1234567890123456";
    
    /**
     * 加密
     * 
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static String encrypt(byte[] data, String key) throws Exception {
        if(key == null) {
             return null;
        }
        byte[] rawKey = null;
        // 如果key的长度不为16,则后面补八个0
        if(key.length() != 16) {
            rawKey = getRawKey(key.getBytes());
            System.out.println("key字符串的长度应该是16位.");
        } else {
            rawKey = key.getBytes();
        }
        SecretKeySpec keySpec = new SecretKeySpec(rawKey, AES);
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        int blockSize = cipher.getBlockSize();
        int plaintextLength = data.length;
        if(plaintextLength % blockSize != 0) {
            plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
        }
        byte[] plaintext = new byte[plaintextLength];
        System.arraycopy(data, 0, plaintext, 0, data.length);
        IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
        byte[] encrypted = cipher.doFinal(plaintext);
        String ivHex = HexUtil.byte2hex(iv.getBytes());
        String encryptedHex = HexUtil.byte2hex(encrypted);
       return ivHex + encryptedHex;
    }
    
    /**
     * 解密
     * 
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static String decrypt(String data, String key) throws Exception {
        if(key == null) {
            return null;
        } 
        byte[] rawKey = null;
        // 如果key的长度不为16,则后面补八个0
        if(key.length() != 16) {
            rawKey = getRawKey(key.getBytes());
            System.out.println("key字符串的长度应该是16位.");
        } else {
            rawKey = key.getBytes();
        }
        byte[] encrypted = HexUtil.hex2byte(data);
        SecretKeySpec keySpec = new SecretKeySpec(rawKey, AES);
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);       
        byte[] original = cipher.doFinal(encrypted);
        return new String(original);
    }
    
    
   

	

	private static byte[] getRawKey(byte[] seed) throws Exception {
		byte[] afterSeed = new byte[2 * seed.length];
		for (int i = 0; i < seed.length; i++) {
			afterSeed[i] = seed[i];
		}
		for (int i = seed.length; i < afterSeed.length; i++) {
			afterSeed[i] = 0;
		}
		return afterSeed;
	}


}
