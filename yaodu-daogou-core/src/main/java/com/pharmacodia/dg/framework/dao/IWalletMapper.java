package com.pharmacodia.dg.framework.dao;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.pharmacodia.dg.framework.datamodel.Wallet;

/**
 * 示例的O/R Mapping ,比如钱包相关的O/R Mapping
 * <p/>
 * <p><b>User:</b> charles.wang <a href="mailto:charles.wang0@pactera.com">charles.wang0@pactera.com</a></p>
 * <p><b>Date:</b> 2015-01-06 </p>
 *
 * @author charles.wang
 */


public interface IWalletMapper {
	
	/**
	 * 创建卡包
	 * @param wallet
	 * @return 创建卡包成功后返回的卡包id
	 */
	void createWallet(Wallet wallet);
	
	/**
	 * 重置卡包支付密码 
	 * @param wallet
	 */
	void resetPassword(Wallet wallet);
	
	/**
	 * 根据卡包ID来获取卡包
	 */
	Wallet getWalletById(long id);
	
	
	/**
	 * 分页获取给定页的卡包列表
	 */
	
	List<Wallet> retrieveWallets(PageBounds bounds);
	
	/**
	 * 获取卡包数量
	 */
	int getTotalCount();
	
	

}
