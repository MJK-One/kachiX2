package com.kachi.five.DAO;

import java.util.List;

import com.kachi.five.bean.AddressBean;
import com.kachi.five.bean.UserBean;

public interface UserDAO {
	void insertUser(UserBean user);
    UserBean getUser(String userID) throws Exception;
	public List<UserBean> test() throws Exception;
	public void updateNickname(UserBean user);
	void insertAddress(AddressBean address);
}
