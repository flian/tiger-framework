package com.pharmacodia.dg.framework.controller;

import java.util.List;

import com.pharmacodia.dg.framework.datamodel.Product;
import com.pharmacodia.dg.framework.datamodel.SKU;
import com.pharmacodia.dg.framework.dbservice.IProductService;
import com.pharmacodia.dg.framework.dto.SkuListDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

	private static final Logger LOGGER = Logger.getLogger(ProductController.class);
	
	@Autowired
	private IProductService productService;
	
	@RequestMapping(value="/list")
	public String list(Model model,PageBounds pg,final Long productId) {
		List<SkuListDTO> list = productService.selectSkuListDTO(pg,productId);
		model.addAttribute("sku", list);
		return "/homepage/homepage";
	}
	
	@RequestMapping(value="/detail")
	public String detail(Model model,final Long skuId,final Long productId) {
		SKU sku = productService.getSku(skuId);
		model.addAttribute("sku", sku);
		Product product = productService.get(productId==null?sku.getProductId():productId);
		model.addAttribute("product", product);
		List<SKU> skus = productService.listSkuByProductId(product.getId());
		model.addAttribute("skus", skus);
		return "/product/detail";
	}
}
