package com.tiger.framework.dto;

import java.io.Serializable;

import com.tiger.framework.datamodel.SKU;

public class CartDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private SKU sku;
	
	private Integer buyNum;

	public SKU getSku() {
		return sku;
	}

	public void setSku(SKU sku) {
		this.sku = sku;
	}

	public Integer getBuyNum() {
		return buyNum;
	}

	public void setBuyNum(Integer buyNum) {
		this.buyNum = buyNum;
	}
	
}
