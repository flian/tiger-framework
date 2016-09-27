package com.tiger.framework.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tiger.framework.dbservice.IProductService;
import com.tiger.framework.dto.CartDTO;

@Controller
@RequestMapping(value = "/cart")
public class CartController {

	private static final Logger LOGGER = Logger.getLogger(CartController.class);
	
	@Autowired
	private IProductService productService;
	
	@RequestMapping(value="/buycart")
	public String buycart(Model model,HttpServletRequest request) {
		HttpSession session = request.getSession();
		Object cartobj = session.getAttribute("cart");
		Map<Long, Integer> carts = new HashMap<Long, Integer>();
		if(cartobj!=null){
			carts = (Map<Long, Integer>)cartobj;
		}
		List<CartDTO> resdata = productService.getCart(carts);
		model.addAttribute("carts", resdata);
		return "/cart/buycart";
	}

	@RequestMapping(value="/addcart")
	@ResponseBody
	public Integer addcart(Model model,HttpServletRequest request,
			@RequestParam(required = true)final Long skuId,
			@RequestParam(required = true)final Integer buyNum){
		HttpSession session = request.getSession();
		Map<Long, Integer> carts = new HashMap<Long, Integer>();
		Object cartobj = session.getAttribute("cart");
		if(cartobj!=null){
			carts = (Map<Long, Integer>)cartobj;
		}
		carts.put(skuId, buyNum);
		session.setAttribute("cart", carts);
		return carts.size();
	}
	
	@RequestMapping(value="/cartNum")
	@ResponseBody
	public Map<String, Object> cartNum(Model model,HttpServletRequest request){
		Map<String, Object> resdata = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Object cartobj = session.getAttribute("cart");
		Map<Long, Integer> carts = new HashMap<Long, Integer>();
		if(cartobj!=null){
			 carts = (Map<Long, Integer>)cartobj;
		}
		resdata.put("cartNum", carts.size());
		return resdata;
	}
	
}
