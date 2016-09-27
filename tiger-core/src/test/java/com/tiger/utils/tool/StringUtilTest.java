package com.tiger.utils.tool;

import org.junit.Test;

import com.tiger.utils.tools.StringUtil;

import static org.junit.Assert.assertTrue;

/**
 * @author charles(mailto:charles.wang0@pactera.com)
 *
 */
public class StringUtilTest {

	/**
	 * Test method for {@link com.tiger.utils.tools.StringUtil#string2hexString(java.lang.String)}.
	 */
	@Test
	public void testString2hexString() {
		String string1="12334";
		String hexString1 = StringUtil.string2hexString(string1);
		System.out.println("originalString:"+string1+","+"hexString:"+hexString1);
		
		String string2 = "中文文本";
		String hexString2 = StringUtil.string2hexString(string2);
		System.out.println("originalString:"+string2+","+"hexString:"+hexString2);
		
		assertTrue("3132333334".equals(hexString1));
//		assertTrue("E4B8ADE69687E69687E69CAC".equals(hexString2));
				
	}

	/**
	 * Test method for {@link com.tiger.utils.tools.StringUtil#hexStringToString(java.lang.String)}.
	 */
	@Test
	public void testHexStringToString() {

		String hexString1 = "3132333334";	
		String string1 = StringUtil.hexStringToString(hexString1);
		System.out.println("hexString:"+hexString1+","+"originalString:"+string1);
		assertTrue("12334".equals(string1));
		
		String hexString2 = "E4B8ADE69687E69687E69CAC";
		String string2 = StringUtil.hexStringToString(hexString2);
		System.out.println("hexString:"+hexString2+","+"originalString:"+string2);
		assertTrue("中文文本".equals(string2));
		
		
		
	}

}
