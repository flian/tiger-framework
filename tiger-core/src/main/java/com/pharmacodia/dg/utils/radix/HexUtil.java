package com.pharmacodia.dg.utils.radix;

/**
 * 工具类：提供了BYTE和16进制的转换
 * <p/>
 * <p><b>User:</b> charles.wang <a href="mailto:charles.wang0@pactera.com">charles.wang0@pactera.com</a></p>
 * <p><b>Date:</b> 2015-01-06 </p>
 *
 * @author charles.wang
 */
public class HexUtil {
    
    private HexUtil() {
        
    }

    public static String byte2hex(byte[] data) {
        String hs = "";
        String stmp = "";
        for(int n = 0; n < data.length; n++) {
            stmp = (Integer.toHexString(data[n]&0XFF));
            if(stmp.length() == 1) {
                hs = hs + "0" + stmp;
            }else {
                hs = hs + stmp;
            }
        }
        return hs.toLowerCase();
    }
    
    public static byte[] hex2byte(String data) {
        if(data == null) {
            return null;
        }
        int length = data.length();
        if(length % 2 == 1) {
            throw new IllegalArgumentException("长度不是偶数");
        }
        byte[] b = new byte[length/2];
        for(int i = 0; i != length / 2; i++) {
            b[i] = (byte)Integer.parseInt(data.substring(i*2, i*2 + 2),16);
        }
        return b;
    }

}
