package com.tiger.utils.enums;

public enum OrderStatus {

	WAITPAYMENT("01","待支付"),

	AUDIT_SUCCESS("20","审核通过"),
	AUDIT_FAILUE("21","审核未通过"),

	SHIPPING("30","已发货");

	OrderStatus(String index, String value) {
		this.index = index;
		this.value = value;
	}

	private String index;

	private String value;

	public String getIndex() {
		return index;
	}

	public String getValue() {
		return value;
	}

}