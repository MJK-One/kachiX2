package com.kachi.five.service;

import java.util.List;

import com.kachi.five.bean.AddressBean;
import com.kachi.five.bean.PostBean;
import com.kachi.five.bean.UserBean;

public interface UserService {
	public void updateNickname(UserBean user);
	public void insertAddress(AddressBean address);
	public List<AddressBean> getAddresses(String userId);
	public void deleteAddress(int addressId);
	public void deleteUser(int userId);
	public List<UserBean> getAllUsers()throws Exception;
	public void updateUserPermission(UserBean user) throws Exception;
}
