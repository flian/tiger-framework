package com.pharmacodia.dg.framework.dbservice;

import com.pharmacodia.dg.framework.datamodel.UserAddress;

public interface IUserAddressService {
	
	public UserAddress getDefaultAddressByUserId(Long userId);
}
