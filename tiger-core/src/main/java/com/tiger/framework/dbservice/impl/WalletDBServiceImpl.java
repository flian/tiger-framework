package com.tiger.framework.dbservice.impl;



import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.tiger.framework.dao.IWalletMapper;
import com.tiger.framework.datamodel.Pager;
import com.tiger.framework.datamodel.Wallet;
import com.tiger.framework.dbservice.IWalletDBService;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 示例实现类：与钱包相关的数据库服务实现类
 * <p/>
 * <p><b>User:</b> charles.wang <a href="mailto:charles.wang0@pactera.com">charles.wang0@pactera.com</a></p>
 * <p><b>Date:</b> 2015-01-06 </p>
 *
 * @author charles.wang
 */

@Service("walletDBService")
public class WalletDBServiceImpl implements IWalletDBService {

	@Resource(name = "frameworkSqlSession")
	private SqlSession frameworkSqlSession;


	private static final Logger LOGGER = Logger.getLogger(WalletDBServiceImpl.class);

	/**
	 * 创建卡包
	 */
	@Override
	@Transactional
	public long createWallet(String nickName, String userId, String payPassword) {

		// 先根据入参创建一个卡包对象
		Wallet wallet = new Wallet();
		wallet.setNickName(nickName);
		wallet.setUserId(userId);
		wallet.setPayPassword(payPassword);
		wallet.setStatus(1); // 设定卡包为可使用状态
		
		IWalletMapper walletMapper = frameworkSqlSession.getMapper(IWalletMapper.class);
		walletMapper.createWallet(wallet);
		return wallet.getId();
	}


	@Override
	@Transactional
	public void resetPassword(String userId, String newPassword) {
		Wallet wallet = new Wallet();
		wallet.setUserId(userId);
		wallet.setPayPassword(newPassword);
		LOGGER.info("userId:"+userId+",newPassword:"+newPassword);
		IWalletMapper walletMapper = frameworkSqlSession.getMapper(IWalletMapper.class);
		walletMapper.resetPassword(wallet);

	}
	
	 @Override
	 public int retrieveWalletNumber(){
		 IWalletMapper walletMapper = frameworkSqlSession.getMapper(IWalletMapper.class);
		 return walletMapper.getTotalCount();
	 }

    @Override
    public List<Wallet> retrieveWalletListByPagination(PageBounds pg) {
        IWalletMapper walletMapper = frameworkSqlSession.getMapper(IWalletMapper.class);
        return walletMapper.retrieveWallets(pg);
    }
}
