package com.kachi.five.service;

import com.kachi.five.bean.AddressBean;
import com.kachi.five.bean.UserBean;

public interface UserService {
	void updateNickname(UserBean user);
	void insertAddress(AddressBean address);
}
