package com.tiger.framework.dao;

import java.util.List;
import java.util.Set;

import com.tiger.framework.datamodel.Menu;
import com.tiger.framework.datamodel.ShiroUser;

/**
 * TODO
 * <p/>
 * <p><b>User:</b> charles.wang <a href="mailto:charles.wang0@pactera.com">charles.wang0@pactera.com</a></p>
 * <p><b>Date:</b> 下午1:46:53 </p>
 *
 * @author charles.wang
 */

public interface IShiroUserMapper {
	
	/**
	 * 根据用户名来获取ShiroUser对象
	 * @param userName 用户名
	 * @return ShiroUser对象
	 */
	ShiroUser fetchUserByName (String userName);
	
	
	/**
	 * 根据用户名来获取角色集合
	 * @param userName 用户名
	 * @return Set<String> 角色集合
	 */
	Set<String> fetchUserRolesByName(String userName);
	
	/**
	 * 根据用户名来获取权限集合
	 * @param userName 用户名
	 * @return Set<String> 权限集合
	 */
	Set<String> fetchUserPermissionsByName(String userName);
	
	/**
	 * 根据用户名来获取菜单集合
	 * @param userName 用户名
	 * @return List<MenuDTO> 菜单集合
	 */
	List<Menu> fetchUserMenusByName (String userName);

	public boolean updatePassword(String userName, String newPassword,String salt);

	public boolean saveOrUpdate(ShiroUser user);
}
