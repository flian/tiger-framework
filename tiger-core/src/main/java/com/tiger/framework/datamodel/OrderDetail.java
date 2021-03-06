package com.tiger.framework.datamodel;

import java.math.BigDecimal;

public class OrderDetail {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_detail.ID
     *
     * @mbggenerated Tue Jun 14 10:53:15 CST 2016
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_detail.ORDER_ID
     *
     * @mbggenerated Tue Jun 14 10:53:15 CST 2016
     */
    private String orderId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_detail.PRODUCT_ID
     *
     * @mbggenerated Tue Jun 14 10:53:15 CST 2016
     */
    private Long productId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_detail.SKU_ID
     *
     * @mbggenerated Tue Jun 14 10:53:15 CST 2016
     */
    private Long skuId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_detail.NAME
     *
     * @mbggenerated Tue Jun 14 10:53:15 CST 2016
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_detail.LIST_PRICE
     *
     * @mbggenerated Tue Jun 14 10:53:15 CST 2016
     */
    private BigDecimal listPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_detail.SALE_PRICE
     *
     * @mbggenerated Tue Jun 14 10:53:15 CST 2016
     */
    private BigDecimal salePrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_detail.BUY_NUM
     *
     * @mbggenerated Tue Jun 14 10:53:15 CST 2016
     */
    private Integer buyNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_detail.TOTAL_MONEY
     *
     * @mbggenerated Tue Jun 14 10:53:15 CST 2016
     */
    private BigDecimal totalMoney;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_detail.REMARK
     *
     * @mbggenerated Tue Jun 14 10:53:15 CST 2016
     */
    private String remark;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_detail.ID
     *
     * @return the value of tb_order_detail.ID
     *
     * @mbggenerated Tue Jun 14 10:53:15 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_detail.ID
     *
     * @param id the value for tb_order_detail.ID
     *
     * @mbggenerated Tue Jun 14 10:53:15 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_detail.ORDER_ID
     *
     * @return the value of tb_order_detail.ORDER_ID
     *
     * @mbggenerated Tue Jun 14 10:53:15 CST 2016
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_detail.ORDER_ID
     *
     * @param orderId the value for tb_order_detail.ORDER_ID
     *
     * @mbggenerated Tue Jun 14 10:53:15 CST 2016
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_detail.PRODUCT_ID
     *
     * @return the value of tb_order_detail.PRODUCT_ID
     *
     * @mbggenerated Tue Jun 14 10:53:15 CST 2016
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_detail.PRODUCT_ID
     *
     * @param productId the value for tb_order_detail.PRODUCT_ID
     *
     * @mbggenerated Tue Jun 14 10:53:15 CST 2016
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_detail.SKU_ID
     *
     * @return the value of tb_order_detail.SKU_ID
     *
     * @mbggenerated Tue Jun 14 10:53:15 CST 2016
     */
    public Long getSkuId() {
        return skuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_detail.SKU_ID
     *
     * @param skuId the value for tb_order_detail.SKU_ID
     *
     * @mbggenerated Tue Jun 14 10:53:15 CST 2016
     */
    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_detail.NAME
     *
     * @return the value of tb_order_detail.NAME
     *
     * @mbggenerated Tue Jun 14 10:53:15 CST 2016
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_detail.NAME
     *
     * @param name the value for tb_order_detail.NAME
     *
     * @mbggenerated Tue Jun 14 10:53:15 CST 2016
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_detail.LIST_PRICE
     *
     * @return the value of tb_order_detail.LIST_PRICE
     *
     * @mbggenerated Tue Jun 14 10:53:15 CST 2016
     */
    public BigDecimal getListPrice() {
        return listPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_detail.LIST_PRICE
     *
     * @param listPrice the value for tb_order_detail.LIST_PRICE
     *
     * @mbggenerated Tue Jun 14 10:53:15 CST 2016
     */
    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_detail.SALE_PRICE
     *
     * @return the value of tb_order_detail.SALE_PRICE
     *
     * @mbggenerated Tue Jun 14 10:53:15 CST 2016
     */
    public BigDecimal getSalePrice() {
        return salePrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_detail.SALE_PRICE
     *
     * @param salePrice the value for tb_order_detail.SALE_PRICE
     *
     * @mbggenerated Tue Jun 14 10:53:15 CST 2016
     */
    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_detail.BUY_NUM
     *
     * @return the value of tb_order_detail.BUY_NUM
     *
     * @mbggenerated Tue Jun 14 10:53:15 CST 2016
     */
    public Integer getBuyNum() {
        return buyNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_detail.BUY_NUM
     *
     * @param buyNum the value for tb_order_detail.BUY_NUM
     *
     * @mbggenerated Tue Jun 14 10:53:15 CST 2016
     */
    public void setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_detail.TOTAL_MONEY
     *
     * @return the value of tb_order_detail.TOTAL_MONEY
     *
     * @mbggenerated Tue Jun 14 10:53:15 CST 2016
     */
    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_detail.TOTAL_MONEY
     *
     * @param totalMoney the value for tb_order_detail.TOTAL_MONEY
     *
     * @mbggenerated Tue Jun 14 10:53:15 CST 2016
     */
    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_detail.REMARK
     *
     * @return the value of tb_order_detail.REMARK
     *
     * @mbggenerated Tue Jun 14 10:53:15 CST 2016
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_detail.REMARK
     *
     * @param remark the value for tb_order_detail.REMARK
     *
     * @mbggenerated Tue Jun 14 10:53:15 CST 2016
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}