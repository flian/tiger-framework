package com.tiger.framework.controller;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.tiger.framework.dbservice.IProductService;
import com.tiger.framework.dto.SkuListDTO;

/**
 * 前台首页
 * <p/>
 * <p><b>User:</b> charles.wang <a href="mailto:charles.wang0@pactera.com">charles.wang0@pactera.com</a></p>
 * <p><b>Date:</b> 2015-01-06 </p>
 *
 * @author charles.wang
 */

@Controller
public class HomeController {
	
	private static final Logger LOGGER = Logger.getLogger(HomeController.class);
	
	@Autowired
	private IProductService productService;
	
	/**
    *
    * @param model
    * @return
    */
   @RequestMapping(value="/index")
   public String index(Model model,PageBounds pg,final Long productId) {
	   List<SkuListDTO> list = productService.selectSkuListDTO(pg,productId);
		model.addAttribute("sku", list);
       return "/homepage/homepage";
   }
	
	/**
     *
     * @param model
     * @return
     */
    @RequestMapping(value="/home")
    public String homepage(Model model,PageBounds pg,final Long productId) {
    	List<SkuListDTO> list = productService.selectSkuListDTO(pg,productId);
		model.addAttribute("sku", list);
        return "/homepage/homepage";
    }
    	
}
