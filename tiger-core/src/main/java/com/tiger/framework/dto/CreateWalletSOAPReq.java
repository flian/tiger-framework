package com.tiger.framework.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * DTO DEMO:创建钱包的SOAP的请求DTO对象
 * <p/>
 * <p><b>User:</b> charles.wang <a href="mailto:charles.wang0@pactera.com">charles.wang0@pactera.com</a></p>
 * <p><b>Date:</b> 2015-01-06 </p>
 *
 * @author charles.wang
 */


@XmlRootElement
public class CreateWalletSOAPReq implements Serializable {
	

	private static final long serialVersionUID = -6662792928815702312L;
	
	
	private String nickName;
	private String paymentPassword;
	private String userId;

    public CreateWalletSOAPReq(){}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPaymentPassword() {
		return paymentPassword;
	}

	public void setPaymentPassword(String paymentPassword) {
		this.paymentPassword = paymentPassword;
	}

    public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	@Override
	public String toString(){
		return "[nickname:"+nickName+"],[paymentPassword:"+paymentPassword+"],[userId:"+userId+"]";
	}

}
