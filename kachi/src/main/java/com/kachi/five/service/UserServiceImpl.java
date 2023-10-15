package com.kachi.five.service;

import java.util.List;

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
	    try {
	        userDao.updateNickname(user);
	    } catch (Exception e) {
	       
	        e.printStackTrace();
	        System.out.println("Error updating nickname: " + e.getMessage());
	        
			
			throw new RuntimeException(e); 
	    }
	}
	@Override
	public void insertAddress(AddressBean address) {
		userDao.insertAddress(address);
	}
	@Override
	public List<AddressBean> getAddresses(String userId) {
	    return userDao.getAddresses(userId);
	}
	@Override
	public void deleteAddress(int addressId) {
	   userDao.deleteAddress(addressId);
	}
	@Override
	public void deleteUser(int userId) {
		userDao.deleteUser(userId);
		
	}
	@Override
	public List<UserBean> getAllUsers() {
	    try {
	        return userDao.getAllUsers();
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Error Message: " + e.getMessage());
	        
			
			throw new RuntimeException(e); 
	    }
	}
	@Override
	public void updateUserPermission(UserBean user) throws Exception {
		userDao.updateUserPermission(user);
		
	}
	
	
}
	

