package com.tiger.framework.security.freemarker;

import java.io.IOException;

import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.tiger.framework.security.freemarker.tag.ShiroTags;

import freemarker.template.TemplateException;


/**
 *
 * 为解决FreeMarker上无法使用Shiro标签库
 * 自定义ShiroTagFreemarkerConfigurer来扩展Spring本身提供的FreeMarkerConfigurer
 * <p/>
 * <p><b>User:</b> charles.wang <a href="mailto:charles.wang0@pactera.com">charles.wang0@pactera.com</a></p>
 * <p><b>Date:</b> 下午10:44:30 </p>
 *
 * @author charles.wang
 */
public class ShiroTagFreeMarkerConfigurer extends FreeMarkerConfigurer {
	 @Override
	    public void afterPropertiesSet() throws IOException, TemplateException {
	        super.afterPropertiesSet();
	        this.getConfiguration().setSharedVariable("shiro", new ShiroTags());
	    }

}
