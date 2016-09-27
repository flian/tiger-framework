package com.tiger.framework.security;

import java.security.Principal;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.security.auth.login.AccountException;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.tiger.framework.datamodel.Menu;
import com.tiger.framework.datamodel.ShiroUser;
import com.tiger.framework.dbservice.IShiroUserDBService;
import com.tiger.framework.dbservice.IWalletDBService;


/**
 * 负责shiro认证和授权的Realm
 * <p/>
 * <p><b>User:</b> charles.wang <a href="mailto:charles.wang0@pactera.com">charles.wang0@pactera.com</a></p>
 * <p><b>Date:</b> 下午12:54:20 </p>
 *
 * @author charles.wang
 */

public class UserRealm extends AuthorizingRealm {
	
	
	//注入用户认证服务
	@Resource(name = "shiroUserDBService")
	private IShiroUserDBService shiroUserDBService;
		
	private static final Logger LOGGER = Logger.getLogger(UserRealm.class);
	
	/**
	 * 认证方法，它主要做以下事情：
	 * 1.检查提交的进行认证的令牌信息
	 * 2.根据令牌信息从数据源（通常为DB）中获取用户信息
	 * 3.对用户信息进行匹配验证
	 * 4.如果验证通过返回一个封装了用户信息的AuthenticationInfo实例，验证不通过则抛出AuthenticationException异常
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		String userName = usernamePasswordToken.getUsername();
		String password = new String(usernamePasswordToken.getPassword());
		//从SQL查询获得该用户名匹配的用户信息
		ShiroUser user = shiroUserDBService.retrieveUserByName(userName);
		if(user==null)
			throw new UnknownAccountException();
		
		//交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
		SimpleAuthenticationInfo authnInfo = new SimpleAuthenticationInfo(user.getUserName(),user.getPassword(),getName());
		return authnInfo;
	}
	
	/**
	 * 授权方法
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals)  {
		//UserLoginResponseDTO dto = (UserLoginResponseDTO)principals.getPrimaryPrincipal(); 
		String loginName =(String)principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo(); 

        
        //从DB中获取其对应的权限列表和角色列表还有菜单列表 
        Set<String> roles = shiroUserDBService.retrieveUserRolesByName(loginName);
        Set<String> permissions = shiroUserDBService.retrieveUserPermissionsByName(loginName);
        List<Menu> menus = shiroUserDBService.retrieveUserMenusByName(loginName); 
        //设置与某人挂钩的角色集和权限集，这样可以在页面上使用shiro标签来进行授权
	    authorizationInfo.setRoles(roles);  
	    authorizationInfo.setStringPermissions(permissions);
	   
	    
		return authorizationInfo;
		
	}

	

}
