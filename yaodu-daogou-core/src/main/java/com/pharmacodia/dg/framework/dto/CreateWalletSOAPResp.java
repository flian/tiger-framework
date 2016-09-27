package com.pharmacodia.dg.framework.dto;

import java.util.Date;

/**
 * DTO DEMO:创建钱包的SOAP响应的DTO对象
 * <p/>
 * <p><b>User:</b> charles.wang <a href="mailto:charles.wang0@pactera.com">charles.wang0@pactera.com</a></p>
 * <p><b>Date:</b> 2015-01-06 </p>
 *
 * @author charles.wang
 */
public class CreateWalletSOAPResp {

	private int procCode;
	private String message;
	private String createAt;	   
	   
    public int getProcCode() {
		return procCode;
	}
	public void setProcCode(int procCode) {
		this.procCode = procCode;
	}
	public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
	public String getCreateAt() {
		return createAt;
	}
	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}
    
    
}
