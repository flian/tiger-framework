package com.tiger.framework.datamodel;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * 菜单对象，包含菜单ID，名称，动作URL
 * <p/>
 * <p><b>User:</b> charles.wang <a href="mailto:charles.wang0@pactera.com">charles.wang0@pactera.com</a></p>
 * <p><b>Date:</b> 上午10:50:40 </p>
 *
 * @author charles.wang
 */
public class Menu implements Serializable{
	private static final long serialVersionUID = 6357460166762663160L;
	private long id;
	private String name;
	private String url;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


}
