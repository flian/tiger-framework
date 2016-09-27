package com.pharmacodia.dg.framework.dbservice.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pharmacodia.dg.framework.dao.OrderAddressMapper;
import com.pharmacodia.dg.framework.dao.OrderDetailMapper;
import com.pharmacodia.dg.framework.dao.OrderMasterMapper;
import com.pharmacodia.dg.framework.dao.SKUMapper;
import com.pharmacodia.dg.framework.dao.UserAddressMapper;
import com.pharmacodia.dg.framework.datamodel.OrderAddress;
import com.pharmacodia.dg.framework.datamodel.OrderDetail;
import com.pharmacodia.dg.framework.datamodel.OrderDetailExample;
import com.pharmacodia.dg.framework.datamodel.OrderMaster;
import com.pharmacodia.dg.framework.datamodel.OrderMasterExample;
import com.pharmacodia.dg.framework.datamodel.SKU;
import com.pharmacodia.dg.framework.datamodel.ShiroUser;
import com.pharmacodia.dg.framework.datamodel.UserAddress;
import com.pharmacodia.dg.framework.dbservice.IOrderService;
import com.pharmacodia.dg.framework.dto.OrderDTO;
import com.pharmacodia.dg.utils.enums.BooleanEnum;
import com.pharmacodia.dg.utils.enums.OrderStatus;
import com.pharmacodia.dg.utils.generate.IdWorker;

/**
 * 
 * @author Fair
 *
 */
@Service
public class OrderServiceImpl implements IOrderService {

	private static final Logger LOGGER = Logger.getLogger(OrderServiceImpl.class);
	
	@Resource(name = "frameworkSqlSession")
    private SqlSession frameworkSqlSession;

	@Transactional
	@Override
	public OrderDTO saveOrder(ShiroUser user,Map<Long, Integer> carts,Long addressId,String remark) {
		//创建订单
		OrderDTO dto = new OrderDTO();
		String orderId = "";
		try {
			IdWorker id = new IdWorker(1);
			orderId = String.valueOf(id.nextId());
		} catch (Exception e) {
			LOGGER.error("generate id error",e);
			throw new RuntimeException("generate id error"); 
		}
		//获取送货地址
		UserAddressMapper userAddressMapper = frameworkSqlSession.getMapper(UserAddressMapper.class);
		UserAddress userAddress = userAddressMapper.selectByPrimaryKey(addressId);
		
		//新增收货地址
		OrderAddress address = new OrderAddress();
		address.setOrderId(orderId);
		address.setName(userAddress.getName());
		address.setPhone(userAddress.getPhone());
		address.setTelephone(userAddress.getTelephone());
		address.setProvince(userAddress.getProvince());
		address.setCity(userAddress.getCity());
		address.setCountry(userAddress.getCountry());
		address.setContent(userAddress.getContent());
		
		OrderAddressMapper addressMapper = frameworkSqlSession.getMapper(OrderAddressMapper.class);
		addressMapper.insertSelective(address);
		
		dto.setAddress(address);

		//订单明细添加
		BigDecimal totalMoney = BigDecimal.ZERO;
		OrderDetailMapper detailMapper = frameworkSqlSession.getMapper(OrderDetailMapper.class);
		SKUMapper skuMapper = frameworkSqlSession.getMapper(SKUMapper.class);
		List<OrderDetail> details = new ArrayList<OrderDetail>();
		for (Map.Entry<Long, Integer> entry : carts.entrySet()) {
			SKU sku = skuMapper.selectByPrimaryKey(entry.getKey());
			OrderDetail detail = new OrderDetail();
			detail.setOrderId(orderId);
			detail.setProductId(sku.getProductId());
			detail.setSkuId(sku.getId());
			detail.setName(sku.getName());
			detail.setListPrice(new BigDecimal(sku.getListPrice()));
			detail.setSalePrice(new BigDecimal(sku.getSalePrice()));
			detail.setBuyNum(entry.getValue());
			BigDecimal total = new BigDecimal(sku.getSalePrice()*entry.getValue());
			totalMoney = totalMoney.add(total);
			detail.setTotalMoney(total);
			detailMapper.insertSelective(detail);
			details.add(detail);
		}
		
		dto.setDetails(details);
		
		//订单主表添加
		OrderMasterMapper masterMapper = frameworkSqlSession.getMapper(OrderMasterMapper.class);
		OrderMaster master = new OrderMaster();
		master.setOrderId(orderId);
		master.setTotalMoney(totalMoney);
		master.setFreight(BigDecimal.ZERO);
		master.setOrderStatus(OrderStatus.WAITPAYMENT.getIndex());
		master.setIsDel(BooleanEnum.FALSE.getIndex());
		master.setAddressId(address.getId());
		master.setOrderCreater(String.valueOf(user.getId()));
		master.setCreatedTime(new Date());
		masterMapper.insertSelective(master);
		
		dto.setMaster(master);
		
		//扣减库存
		for (OrderDetail d : details) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("stockLevel", d.getBuyNum());
			params.put("id", d.getSkuId());
			int ret = frameworkSqlSession.update("com.tiger.framework.dao.SKUMapper.updateStockLevel", params);
			if(ret<1){
				String errMsg = "stock level minus error,sku id :" + d.getSkuId()+",stockLevel :" + d.getBuyNum();
				LOGGER.error(errMsg);
				throw new RuntimeException("订单商品"+d.getSkuId()+"：库存扣减失败"); 
			}
		}
		return dto;
	}

	@Override
	public OrderDTO getOrderByOrderId(String orderId) {
		OrderDTO dto = new OrderDTO();
		
		OrderMasterMapper masterMapper = frameworkSqlSession.getMapper(OrderMasterMapper.class);
		OrderMasterExample masterExample = new OrderMasterExample(); 
		masterExample.or().andOrderIdEqualTo(orderId);
		List<OrderMaster> masterList = masterMapper.selectByExample(masterExample);
		if(masterList!=null&&!masterList.isEmpty()){
			OrderMaster master = masterList.get(0);
			dto.setMaster(master);
			
			OrderAddressMapper addressMapper = frameworkSqlSession.getMapper(OrderAddressMapper.class);
			OrderAddress address = addressMapper.selectByPrimaryKey(master.getAddressId());
			if(address!=null){
				dto.setAddress(address);
			}else{
				LOGGER.info("get Order address by addressId is empty, addressId:"+ master.getAddressId());
				return null;
			}
		}else{
			LOGGER.info("get Order master by orderId is empty, orderId:"+orderId);
			return null;
		}
		
		OrderDetailMapper detailMapper = frameworkSqlSession.getMapper(OrderDetailMapper.class);
		OrderDetailExample detailExample = new OrderDetailExample();
		detailExample.or().andOrderIdEqualTo(orderId);
		List<OrderDetail> detailList = detailMapper.selectByExample(detailExample);
		if(detailList!=null&&!detailList.isEmpty()){
			dto.setDetails(detailList);
		}else{
			LOGGER.info("get Order details by orderId is empty, orderId:"+orderId);
			return null;
		}
		return dto;
	}

	@Override
	public List<OrderDTO> getOrderList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderMaster> getOrderMasterList() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 *根据搜索关键字和分页参数返回订单列表
	 *
	 * @param keyword 搜索关键字
	 * @param page 分页参数
	 * @return
	 */
	@Override
	public List<OrderDTO> queryOrderByKeyandPage(String keyword, PageBounds page) {
		List<OrderDTO> orders=new ArrayList<OrderDTO>();
		OrderMasterMapper masterMapper = frameworkSqlSession.getMapper(OrderMasterMapper.class);
		OrderAddressMapper addressMapper = frameworkSqlSession.getMapper(OrderAddressMapper.class);
		OrderDetailMapper detailMapper = frameworkSqlSession.getMapper(OrderDetailMapper.class);
		List<OrderMaster> masterList = masterMapper.queryByKeyword(keyword, page);
		if(masterList != null && !masterList.isEmpty()){
			for(OrderMaster orderMaster:masterList){
				OrderDTO dto=new OrderDTO();
				orders.add(dto);
				dto.setMaster(orderMaster);
				dto.setAddress(addressMapper.selectByPrimaryKey(orderMaster.getAddressId()));
				OrderDetailExample detailExample = new OrderDetailExample();
				detailExample.or().andOrderIdEqualTo(orderMaster.getOrderId());
				dto.setDetails(detailMapper.selectByExample(detailExample));
			}
		}
		return new PageList<OrderDTO>(orders,((PageList)masterList).getPaginator());
	}

	@Transactional
	@Override
	public boolean auditOrder(String orderId,String newOrderStatus, String comment) {
		OrderMasterMapper masterMapper = frameworkSqlSession.getMapper(OrderMasterMapper.class);
		masterMapper.auditOrder(orderId, newOrderStatus, comment);
		return true;
	}

	@Transactional
	@Override
	public boolean shipOrder(String orderId) {
		OrderMasterMapper masterMapper = frameworkSqlSession.getMapper(OrderMasterMapper.class);
		masterMapper.shipOrder(orderId,OrderStatus.SHIPPING.getIndex());
		return true;
	}
}
