package com.tiger.framework.dbservice;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.tiger.framework.datamodel.OrderMaster;
import com.tiger.framework.datamodel.ShiroUser;
import com.tiger.framework.dto.OrderDTO;

public interface IOrderService {

	public OrderDTO saveOrder(ShiroUser user,Map<Long, Integer> carts,Long addressId,String remark);
	
	public OrderDTO getOrderByOrderId(String orderId);
	
	public List<OrderDTO> getOrderList();
	
	public List<OrderMaster> getOrderMasterList();

	public List<OrderDTO> queryOrderByKeyandPage(String keyword,PageBounds page);

	public boolean auditOrder(String orderId, String newOrderStatus,String comment);

	public boolean shipOrder(String orderId);

}
