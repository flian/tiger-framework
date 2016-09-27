package com.pharmacodia.dg.utils.tool;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.pharmacodia.dg.utils.tools.HashMapUtil;
import org.junit.Test;

import com.pharmacodia.dg.objects.Person;

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
