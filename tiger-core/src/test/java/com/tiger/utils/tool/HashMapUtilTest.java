package com.tiger.utils.tool;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.tiger.objects.Person;
import com.tiger.utils.tools.HashMapUtil;

public class HashMapUtilTest {

	@Test
	public void testObjToHash() throws Exception {
		//fail("Not yet implemented");
		
		Person person1 = new Person();
		person1.setName("charles.wang");
		person1.setAge(29);
		List<String> friends  = new ArrayList<String>();
		friends.add("wangtianpei");
		friends.add("zhangyanhui");
		person1.setFriends(friends);
		
		Map<String,Object> finalHashMap = HashMapUtil.objToHash(person1);
		assertTrue(finalHashMap.toString().equals("{friends=[wangtianpei, zhangyanhui], name=charles.wang, age=29}"));
	}

}
