package com.tiger.framework.dto;

import java.io.Serializable;

/**
 * DTO DEMO:RESTful请求的通用响应DTO对象
 * <p/>
 * <p><b>User:</b> charles.wang <a href="mailto:charles.wang0@pactera.com">charles.wang0@pactera.com</a></p>
 * <p><b>Date:</b> 2015-01-06 </p>
 *
 * @author charles.wang
 */
public class RESTResponseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
    /** 响应码 */
	private int procCode;
	private Object payload;
	private String message;
	

	public Object getPayload() {
		return payload;
	}
	public void setPayload(Object payload) {
		this.payload = payload;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

    public int getProcCode() {
        return procCode;
    }

    public void setProcCode(int procCode) {
        this.procCode = procCode;
    }
}
