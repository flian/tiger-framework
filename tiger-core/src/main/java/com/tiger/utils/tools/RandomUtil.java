package com.tiger.utils.tools;

import java.util.Random;
import java.util.UUID;

/**
 * 工具类，用于产生随机数和随机字符串
 * <p/>
 * <p><b>User:</b> charles.wang <a href="mailto:charles.wang0@pactera.com">charles.wang0@pactera.com</a></p>
 * <p><b>Date:</b> 2015-01-06 </p>
 *
 * @author charles.wang
 */
public class RandomUtil {


	private RandomUtil() {}
	
	/**
	 * 产生随机的UUID
	 * @return   uuid字符串
	 */
	public static String getRandomUUID()
	  {
	    return UUID.randomUUID().toString();
	  }
	
	/**
	 * 产生随机的带或者不带-的UUID
	 * @param dash 是否带dash符号
	 * @return  uuid字符串
	 */
	public static String getRandomUUID(boolean dash) {
	    return dash ? getRandomUUID() : getRandomUUID().replace("-", "");
	 }
	
	/**
	 * 产生随机字符串
	 * @param acceptChars  接受的字符列表
	 * @param length       长度
	 * @return 符合要求的字符串
	 */
	public static String getRandomString(String acceptChars, int length) {
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < length; i++) {
	      sb.append(getRandomCharacter(acceptChars));
	   }
	    return sb.toString();
	  }

	  public static char getRandomCharacter(String acceptChars) {
	    int index = new Random().nextInt(acceptChars.length());
	    return acceptChars.charAt(index);
	  }

}
