package com.tiger.framework.dbservice;

import com.tiger.framework.datamodel.UserAddress;

public interface IUserAddressService {
	
	public UserAddress getDefaultAddressByUserId(Long userId);
}
