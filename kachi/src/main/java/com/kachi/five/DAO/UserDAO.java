package com.kachi.five.DAO;

import java.util.List;

import com.kachi.five.bean.AddressBean;
import com.kachi.five.bean.UserBean;

public interface UserDAO {
	public void insertUser(UserBean user);
	public  UserBean getUser(String userID) throws Exception;
	public List<UserBean> test() throws Exception;
	public void updateNickname(UserBean user);
	public void insertAddress(AddressBean address);
	public List<AddressBean> getAddresses(String userId);
	public void deleteAddress(int addressId);
	
}
