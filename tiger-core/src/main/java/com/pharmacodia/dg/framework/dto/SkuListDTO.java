package com.pharmacodia.dg.framework.dto;

import java.io.Serializable;

public class SkuListDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private Long productId;
	
	private String name;
	
	private Long price;
	
	private String img;
	
	private Integer stockLevel; 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Integer getStockLevel() {
		return stockLevel;
	}

	public void setStockLevel(Integer stockLevel) {
		this.stockLevel = stockLevel;
	}
	
}
