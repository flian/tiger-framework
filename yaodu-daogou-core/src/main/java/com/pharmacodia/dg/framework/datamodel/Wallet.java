package com.pharmacodia.dg.framework.datamodel;

import java.io.Serializable;
import java.sql.Date;

/**
 * 业务对象模型，比如钱包
 * <p/>
 * <p><b>User:</b> charles.wang <a href="mailto:charles.wang0@pactera.com">charles.wang0@pactera.com</a></p>
 * <p><b>Date:</b> 2015-01-06 </p>
 *
 * @author charles.wang
 */
public class Wallet implements Serializable {
	
	 private static final long serialVersionUID = 1L;
	
	 private long id;
	 private String nickName;
	 private String userId;
	 private String payPassword;
	 private Date lastUsedAt;
	 private Date passwordLastModifiedAt;
	 private Date createdAt;
	 private int status;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPayPassword() {
		return payPassword;
	}
	public void setPayPassword(String payPassword) {
		this.payPassword = payPassword;
	}
	public Date getLastUsedAt() {
		return lastUsedAt;
	}
	public void setLastUsedAt(Date lastUsedAt) {
		this.lastUsedAt = lastUsedAt;
	}
	public Date getPasswordLastModifiedAt() {
		return passwordLastModifiedAt;
	}
	public void setPasswordLastModifiedAt(Date passwordLastModifiedAt) {
		this.passwordLastModifiedAt = passwordLastModifiedAt;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	 
}
