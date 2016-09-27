package com.tiger.utils.enums;

public enum BooleanEnum {

	FALSE("0"),
	TRUE("1");
	
	BooleanEnum(String index){
		this.index = index;
	}
	
	private String index;

	public String getIndex() {
		return index;
	}

}
