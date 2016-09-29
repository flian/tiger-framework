package com.tiger.framework.dbservice.impl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import com.tiger.utils.tools.StringUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.credential.HashingPasswordService;
import org.apache.shiro.crypto.hash.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiger.framework.dao.IShiroUserMapper;
import com.tiger.framework.datamodel.Menu;
import com.tiger.framework.datamodel.ShiroUser;
import com.tiger.framework.datamodel.Wallet;
import com.tiger.framework.dbservice.IShiroUserDBService;


/**
 * 访问用户表
 * <p/>
 * <p><b>User:</b> charles.wang <a href="mailto:charles.wang0@pactera.com">charles.wang0@pactera.com</a></p>
 * <p><b>Date:</b> 下午1:59:15 </p>
 *
 * @author charles.wang
 */


@Service("shiroUserDBService")
public class ShiroUserDBServiceImpl implements IShiroUserDBService{

	public PasswordHelper getPasswordHelper() {
		return passwordHelper;
	}

	public void setPasswordHelper(PasswordHelper passwordHelper) {
		this.passwordHelper = passwordHelper;
	}

	@Autowired
	private PasswordHelper passwordHelper;

	@Resource(name = "frameworkSqlSession")
	private SqlSession frameworkSqlSession;
	private static final Logger LOGGER = Logger.getLogger(WalletDBServiceImpl.class);

	@Override
	@Transactional
	public ShiroUser retrieveUserByName(String userName) {
		LOGGER.info("获取用户名为 ："+userName+" 的信息");
		IShiroUserMapper shiroUserMapper = frameworkSqlSession.getMapper(IShiroUserMapper.class);
		return shiroUserMapper.fetchUserByName(userName);
	}

	@Override
	@Transactional
	public Set<String> retrieveUserRolesByName(String userName) {
		LOGGER.info("获取用户名为："+userName+" 的角色集");
		IShiroUserMapper shiroUserMapper = frameworkSqlSession.getMapper(IShiroUserMapper.class);
		return shiroUserMapper.fetchUserRolesByName(userName);
	}

	@Override
	@Transactional
	public Set<String> retrieveUserPermissionsByName(String userName) {
		LOGGER.info("获取用户名为："+userName+" 的权限集");
		IShiroUserMapper shiroUserMapper = frameworkSqlSession.getMapper(IShiroUserMapper.class);
		return shiroUserMapper.fetchUserPermissionsByName(userName);
	}

	@Override
	@Transactional
	public List<Menu> retrieveUserMenusByName(String userName) {
		LOGGER.info("获取用户名为："+userName+" 的菜单集");
		IShiroUserMapper shiroUserMapper = frameworkSqlSession.getMapper(IShiroUserMapper.class);
		return shiroUserMapper.fetchUserMenusByName(userName);
	}

	@Override
	public boolean updatePassord(String userName, String newPassword) {
		IShiroUserMapper shiroUserMapper = frameworkSqlSession.getMapper(IShiroUserMapper.class);
		ShiroUser user = shiroUserMapper.fetchUserByName(userName);
		user.setPassword(newPassword);
		passwordHelper.encryptPassword(user);
		return shiroUserMapper.updatePassword(userName, user.getPassword(),user.getCredentialsSalt());
	}

	@Override
	public boolean saveOrUpdateUser(ShiroUser user) {
		if(isNew(user)){
			passwordHelper.encryptPassword(user);
		}

		IShiroUserMapper shiroUserMapper = frameworkSqlSession.getMapper(IShiroUserMapper.class);
		return shiroUserMapper.saveOrUpdate(user);
	}

	public boolean isNew(ShiroUser user){
		return StringUtil.isNullOrBlank(user.getSalt())? true:false;
	}

}
