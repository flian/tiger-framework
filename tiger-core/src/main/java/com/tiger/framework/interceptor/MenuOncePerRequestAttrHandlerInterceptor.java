package com.tiger.framework.interceptor;

import com.tiger.framework.datamodel.Menu;
import com.tiger.framework.dbservice.IShiroUserDBService;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * 每次请求处理一下menu
 *
 * Created by foy on 2016-06-01.
 */
public class MenuOncePerRequestAttrHandlerInterceptor extends HandlerInterceptorAdapter {
    static final String MENU_ONCE_PER_REQ_HANDLED="MENU_ONCE_PER_REQ_HANDLED";



    public boolean preHandle(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView)
            throws Exception {
        Boolean isProcessed = (Boolean)request.getAttribute("MENU_ONCE_PER_REQ_HANDLED");
        if(!Boolean.FALSE.equals(isProcessed)){
            String userName = (String) SecurityUtils.getSubject().getPrincipal();
            WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
            IShiroUserDBService shiroUserDBService = (IShiroUserDBService)wac.getBean("shiroUserDBService");
            List<Menu> menuList = shiroUserDBService.retrieveUserMenusByName(userName);
            request.setAttribute("menuList", menuList);
            //modelAndView.getModelMap().addAttribute("menuList",menuList);
            request.setAttribute("MENU_ONCE_PER_REQ_HANDLED",true);
        }
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o, Exception e)
            throws Exception {

    }


    public static String getMenuOncePerReqHandled() {
        return MENU_ONCE_PER_REQ_HANDLED;
    }
}
