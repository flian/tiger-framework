package com.pharmacodia.dg.framework.dbservice;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.pharmacodia.dg.framework.datamodel.Wallet;

/**
 * 业务接口DEMO:与钱包相关的数据库服务接口
 * <p/>
 * <p><b>User:</b> charles.wang <a href="mailto:charles.wang0@pactera.com">charles.wang0@pactera.com</a></p>
 * <p><b>Date:</b> 2015-01-06 </p>
 *
 * @author charles.wang
 */
public interface IWalletDBService {
	
	/**
	 * 卡包服务
	 * @param nickName  卡包的昵称
	 * @param userId    卡包的用户ID
	 * @param payPassword  卡包的支付密码
	 * @return  创建卡包成功后返回的ID
	 */
	long createWallet(String nickName, String userId, String payPassword);
	
	
	/**
	 * 重置卡包支付密码 
	 * @param id
	 */
	void resetPassword(String userId, String password);

    /**
     * 分页显示卡包内的卡列表
     * @param pager pager
     * @return 卡列表
     */
    public List<Wallet> retrieveWalletListByPagination(PageBounds page);
	
	public  int retrieveWalletNumber();
}
