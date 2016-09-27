package com.tiger.framework.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tiger.framework.datamodel.ShiroUser;
import com.tiger.framework.datamodel.UserAddress;
import com.tiger.framework.dbservice.IOrderService;
import com.tiger.framework.dbservice.IProductService;
import com.tiger.framework.dbservice.IShiroUserDBService;
import com.tiger.framework.dbservice.IUserAddressService;
import com.tiger.framework.dto.CartDTO;
import com.tiger.framework.dto.OrderDTO;

@Controller
@RequestMapping(value = "/order")
public class OrderController {
	
	private static final Logger LOGGER = Logger.getLogger(OrderController.class);

	@Autowired
	private IOrderService orderService;
	
	@Autowired
	private IProductService productService;
	
	@Autowired
	private IShiroUserDBService shiroUserDBService;
	
	@Autowired 
	private IUserAddressService userAddressService;
	
	@RequestMapping(value="/confirmOrder")
	public String confirmOrder(Model model){
		Subject sub = SecurityUtils.getSubject();
		String userName = (String)sub.getPrincipal();
		Session session = sub.getSession();
		ShiroUser user = shiroUserDBService.retrieveUserByName(userName);
		Map<Long, Integer> carts = (Map<Long, Integer>)session.getAttribute("cart");
		List<CartDTO> list = productService.getCart(carts);
		UserAddress address = userAddressService.getDefaultAddressByUserId(user.getId());
		
		model.addAttribute("list", list);
		model.addAttribute("address", address);
		return "order/confirmOrder";
	}
	
	@RequestMapping(value="/submitOrder")
	public String submitOrder(Model model,Long addressId) {
		Subject currentUser  = SecurityUtils.getSubject();
		String userName = (String)currentUser.getPrincipal();
		ShiroUser user = shiroUserDBService.retrieveUserByName(userName);
		Map<Long, Integer> carts = (Map<Long, Integer>)currentUser.getSession().getAttribute("cart");
		OrderDTO dto = null;
		try {
			dto = orderService.saveOrder(user, carts, addressId, "");
		} catch (Exception e) {
			model.addAttribute("errMsg", e.getMessage());
			return "order/ordererror";
		}
		model.addAttribute("order", dto);
		SecurityUtils.getSubject().getSession().setAttribute("cart", new HashMap<Long, Integer>());
		return "order/ordersuccess";
	}
	
}
