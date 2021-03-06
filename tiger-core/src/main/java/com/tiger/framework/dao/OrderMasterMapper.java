package com.tiger.framework.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.tiger.framework.datamodel.OrderMaster;
import com.tiger.framework.datamodel.OrderMasterExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMasterMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_master
     *
     * @mbggenerated Tue Jun 14 10:53:15 CST 2016
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_master
     *
     * @mbggenerated Tue Jun 14 10:53:15 CST 2016
     */
    int insert(OrderMaster record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_master
     *
     * @mbggenerated Tue Jun 14 10:53:15 CST 2016
     */
    int insertSelective(OrderMaster record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_master
     *
     * @mbggenerated Tue Jun 14 10:53:15 CST 2016
     */
    List<OrderMaster> selectByExample(OrderMasterExample example);

    List<OrderMaster> selectByExample(OrderMasterExample example,PageBounds bounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_master
     *
     * @mbggenerated Tue Jun 14 10:53:15 CST 2016
     */
    OrderMaster selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_master
     *
     * @mbggenerated Tue Jun 14 10:53:15 CST 2016
     */
    int updateByPrimaryKeySelective(OrderMaster record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_master
     *
     * @mbggenerated Tue Jun 14 10:53:15 CST 2016
     */
    int updateByPrimaryKey(OrderMaster record);

    List<OrderMaster> queryByKeyword(@Param("q")String keyword,PageBounds bounds);

    int shipOrder(@Param("orderId")String orderId,@Param("orderStatus")String newStatus);

    int auditOrder(@Param("orderId")String orderId,@Param("orderStatus")String newStatus,@Param("comment")String comment);
}