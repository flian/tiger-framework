package com.pharmacodia.dg.utils.tools;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 工具类：提供了HashMap和Object之间的转化
 * <p/>
 * <p><b>User:</b> charles.wang <a href="mailto:charles.wang0@pactera.com">charles.wang0@pactera.com</a></p>
 * <p><b>Date:</b> 2015-01-06 </p>
 *
 * @author charles.wang
 */
public class HashMapUtil {
	
	private HashMapUtil(){}
	
	/**
	 * 任意一个对象转为HashMap
	 * @param obj 任意对象
	 * @return    该对象转为的hashmap
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException
	 */
	public static HashMap<String, Object> objToHash(Object obj)
			throws IllegalArgumentException, IllegalAccessException {

		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		//获取对象的类Class对象
		Class clazz = obj.getClass();
		
		//吧类以及所处的父类都添加到List<Class>中
		List<Class> clazzs = new ArrayList<Class>();
		do {
			clazzs.add(clazz);
			clazz = clazz.getSuperclass();
		} while (!clazz.equals(Object.class));
		
		//自下而上去遍历每个Class，吧所有类中的字段都添加到HashMap中，其中key为字段的名字，value为类在这个字段的取值
		for (Class iClazz : clazzs) {
			Field[] fields = iClazz.getDeclaredFields();
			for (Field field : fields) {
				Object objVal = null;
				field.setAccessible(true);
				objVal = field.get(obj);
				hashMap.put(field.getName(), objVal);
			}
		}
		return hashMap;

	}

}
