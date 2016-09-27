package com.tiger.framework.dbservice.impl;

import java.util.HashMap;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.tiger.framework.datamodel.ShiroUser;
import com.tiger.framework.dbservice.IOrderService;
import com.tiger.framework.dto.OrderDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext-dao.xml"})
public class OrderServiceImplTest {
	
	@Autowired
	private IOrderService orderService;
	
	@Test
	public void saveOrder(){
		ShiroUser user = new ShiroUser();
		user.setId(1);
		user.setUserName("charles1");
		
		Map<Long, Integer> carts = new HashMap<Long, Integer>();
		carts.put(6L, 3);
		
		Long addressId = 1L;
		String remark = "快发货";
		orderService.saveOrder(user, carts, addressId, remark);
	}
	
	@Ignore
	public void getOrderByOrderId(){
		OrderDTO dto = orderService.getOrderByOrderId("123");
		Assert.notNull(dto);
	}
}
