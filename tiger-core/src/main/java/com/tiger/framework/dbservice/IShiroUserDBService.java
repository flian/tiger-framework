package com.tiger.framework.dbservice;

import java.util.List;
import java.util.Set;

import com.tiger.framework.datamodel.Menu;
import com.tiger.framework.datamodel.ShiroUser;

/**
 * 与用户认证相关的数据库服务接口
 * <p/>
 * <p><b>User:</b> charles.wang <a href="mailto:charles.wang0@pactera.com">charles.wang0@pactera.com</a></p>
 * <p><b>Date:</b> 下午1:32:00 </p>
 *
 * @author charles.wang
 */

public interface IShiroUserDBService {
	
	/**
	 * 根据用户名获取用户信息
	 * @param userName 用户名
	 * @return User    用户信息
	 */
	ShiroUser retrieveUserByName(String userName);
	
	
	/**
	 * 根据用户名获取用户的角色组
	 * @param userName 用户名
	 * @return Set<String> 用户角色集合
	 */
	Set<String> retrieveUserRolesByName(String userName);
	
	/**
	 * 根据用户名获取用户的权限组
	 * @param userName 用户名
	 * @return Set<String> 用户权限集合
	 */
	Set<String> retrieveUserPermissionsByName(String userName);
	
	/**
	 * 根据用户名获取用户适用的菜单组
	 * @param userName 用户名
	 * @return Liset<MenuDTO> 菜单集合
	 */
    List<Menu> retrieveUserMenusByName(String userName);
}
