package com.pharmacodia.dg.framework.dbservice.impl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pharmacodia.dg.framework.dao.IShiroUserMapper;
import com.pharmacodia.dg.framework.datamodel.Menu;
import com.pharmacodia.dg.framework.datamodel.ShiroUser;
import com.pharmacodia.dg.framework.dbservice.IShiroUserDBService;


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
	
	

}
