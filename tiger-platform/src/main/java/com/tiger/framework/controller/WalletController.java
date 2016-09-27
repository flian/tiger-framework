package com.tiger.framework.controller;

import com.tiger.framework.datamodel.Pager;
import com.tiger.framework.datamodel.Wallet;
import com.tiger.framework.dbservice.IShiroUserDBService;
import com.tiger.framework.dbservice.IWalletDBService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * 示例控制器，比如钱包控制器
 * <p/>
 * <p><b>User:</b> charles.wang <a href="mailto:charles.wang0@pactera.com">charles.wang0@pactera.com</a></p>
 * <p><b>Date:</b> 2015-01-06 </p>
 *
 * @author charles.wang
 */

@Controller
@RequestMapping("/wallet")
public class WalletController {
	
	
	
	//注入卡包数据库服务
	@Resource(name = "walletDBService")
	private IWalletDBService walletDBService;
	
	//注入用户数据库服务
	@Resource(name= "shiroUserDBService")
	private IShiroUserDBService shiroUserDBService;
	
	private static final Logger LOGGER = Logger.getLogger(WalletController.class);
	
	
	/**
     * 获取分页显示的卡包列表,只是简单的DEMO下功能
     * @param model
     * @param pager
     * @return
     */
    @RequestMapping(value="/index")
    public String viewWalletList(HttpServletRequest request,HttpServletResponse response,Model model, Pager pager) {
        if(LOGGER.isDebugEnabled()) {
            LOGGER.debug("entering viewWalletList(Model,Integer) method");
        }

        if(pager == null) {
            pager = new Pager();
        }
        
        
        
        //获得分页的卡包列表
        List<Wallet> walletList = walletDBService.retrieveWalletListByPagination(pager.toPageBounds());
       // model.addAttribute("pager", pager);
        model.addAttribute("walletList", walletList);


       

        return "wallet/list";
    }

}
