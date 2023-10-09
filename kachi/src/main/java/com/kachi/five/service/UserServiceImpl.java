package com.kachi.five.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kachi.five.DAO.UserDAO;
import com.kachi.five.bean.AddressBean;
import com.kachi.five.bean.UserBean;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDao;

	@Override
	public void updateNickname(UserBean user) {
		userDao.updateNickname(user);

	}
	@Override
	public void insertAddress(AddressBean address) {
		userDao.insertAddress(address);
	}
}
