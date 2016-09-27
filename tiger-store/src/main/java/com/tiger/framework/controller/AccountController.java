package com.tiger.framework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.tiger.framework.dbservice.IOrderService;
import com.tiger.utils.enums.OrderStatus;

@Controller
@RequestMapping(value = "/account")
public class AccountController {

	@Autowired
	private IOrderService orderService;
	
	@RequestMapping(value="/myOrder")
	public String myOrder(Model model,String keyword,
			@RequestParam(required =false,defaultValue ="1") int page,
			@RequestParam(required =false,defaultValue ="10") int limit) {
		PageBounds pageBounds = new PageBounds(page,limit);
		model.addAttribute("list", orderService.queryOrderByKeyandPage(keyword, pageBounds));
		model.addAttribute("orderStatus", OrderStatus.values());
		return "account/myOrder";
	}
}
