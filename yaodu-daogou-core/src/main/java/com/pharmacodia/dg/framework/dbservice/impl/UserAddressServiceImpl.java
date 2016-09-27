package com.pharmacodia.dg.framework.dbservice.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmacodia.dg.framework.dao.UserAddressMapper;
import com.pharmacodia.dg.framework.datamodel.UserAddress;
import com.pharmacodia.dg.framework.datamodel.UserAddressExample;
import com.pharmacodia.dg.framework.dbservice.IUserAddressService;
import com.pharmacodia.dg.utils.enums.BooleanEnum;

@Service
public class UserAddressServiceImpl implements IUserAddressService {

private static final Logger logger = Logger.getLogger(UserAddressServiceImpl.class);
	
	@Autowired
    private SqlSession frameworkSqlSession;
	
	@Override
	public UserAddress getDefaultAddressByUserId(Long userId) {
		logger.info("get address by userId : " + userId);
		UserAddressMapper mapper = frameworkSqlSession.getMapper(UserAddressMapper.class);
		UserAddressExample example = new UserAddressExample();
		example.or().andStatusEqualTo(BooleanEnum.TRUE.getIndex());
		example.or().andUserIdEqualTo(userId);
		List<UserAddress> resdata = mapper.selectByExample(example);
		if(resdata!=null&&!resdata.isEmpty()){
			return resdata.get(0);
		}
		return null;
	}

}
