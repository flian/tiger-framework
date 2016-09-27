package com.tigerl.util.radix;

import static org.junit.Assert.*;

import org.junit.Test;

import com.pharmacodia.dg.utils.cipher.EncryptUtil;
import com.pharmacodia.dg.utils.radix.RadixUtil;

public class RadixUtilTest {

	@Test
	public void testRadix() throws Exception{
		String dataHexString="1234567887654321";
		String keyHexString="9AAB1D2EE004AAC3";
		byte[] data = RadixUtil.hexString2Bytes(dataHexString);
		byte[] key =  RadixUtil.hexString2Bytes(keyHexString);
		String algo="DES/ECB/NoPadding";
		byte[] result = EncryptUtil.desEncrypt(data, key,algo);
		System.out.println(RadixUtil.byte2hexString(result));
		assertTrue("7D592BF239849E76".equals(RadixUtil.byte2hexString(result)));
		
	}
	

}
