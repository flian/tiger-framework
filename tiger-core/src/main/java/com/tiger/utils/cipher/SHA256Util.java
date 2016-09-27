package com.tiger.utils.cipher;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 工具类：提供了SHA256加解密的一般方法
 * <p/>
 * <p><b>User:</b> charles.wang <a href="mailto:charles.wang0@pactera.com">charles.wang0@pactera.com</a></p>
 * <p><b>Date:</b> 2015-01-06 </p>
 *
 * @author charles.wang
 */
public class SHA256Util {

    /**
     * SHA-256加密
     * @param source 源字符串
     * @param salt 盐值（用户主键）
     * @return 密文
     */
    public static String encodeSHA256(final String source, final String salt) {
        byte[] data = (source + salt).getBytes();
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256加密失败：" + e.getMessage());
        }
        byte[] digest = md.digest(data);
        return new HexBinaryAdapter().marshal(digest);
    }

}
