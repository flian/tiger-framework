package com.tiger.framework.dto;

import java.io.Serializable;
import java.util.List;

import com.tiger.framework.datamodel.OrderAddress;
import com.tiger.framework.datamodel.OrderDetail;
import com.tiger.framework.datamodel.OrderMaster;

public class OrderDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private OrderMaster master;
	
	private List<OrderDetail> details;
	
	private OrderAddress address;

	public OrderMaster getMaster() {
		return master;
	}

	public void setMaster(OrderMaster master) {
		this.master = master;
	}

	public List<OrderDetail> getDetails() {
		return details;
	}

	public void setDetails(List<OrderDetail> details) {
		this.details = details;
	}

	public OrderAddress getAddress() {
		return address;
	}

	public void setAddress(OrderAddress address) {
		this.address = address;
	}

}
