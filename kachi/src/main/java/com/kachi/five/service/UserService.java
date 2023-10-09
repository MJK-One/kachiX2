package com.kachi.five.service;

import java.util.List;

import com.kachi.five.bean.AddressBean;
import com.kachi.five.bean.UserBean;

public interface UserService {
	void updateNickname(UserBean user);
	void insertAddress(AddressBean address);
	List<AddressBean> getAddresses(String userId);
	void deleteAddress(int addressId);
}
