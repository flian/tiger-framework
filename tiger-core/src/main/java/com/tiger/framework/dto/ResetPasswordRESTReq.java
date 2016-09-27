package com.tiger.framework.dto;

import java.io.Serializable;

/**
 * DTO DEMO:重置钱包的支付密码的RESTful的请求DTO对象
 * <p/>
 * <p><b>User:</b> charles.wang <a href="mailto:charles.wang0@pactera.com">charles.wang0@pactera.com</a></p>
 * <p><b>Date:</b> 2015-01-06 </p>
 *
 * @author charles.wang
 */
public class ResetPasswordRESTReq implements Serializable {

    private static final long serialVersionUID = 2630142348739486938L;
    
    private String userId;
    private String newPassword;

    
    
    public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getNewPassword() {
        return newPassword;
    }
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @Override
    public String toString(){
    	return "[newPassword:"+newPassword+"],[userId:"+userId+"]";
    }
}
