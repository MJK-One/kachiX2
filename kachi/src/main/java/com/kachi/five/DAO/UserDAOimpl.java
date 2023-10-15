package com.kachi.five.DAO;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.kachi.five.bean.AddressBean;
import com.kachi.five.bean.UserBean;

@Repository
public class UserDAOimpl implements UserDAO {
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void insertUser(UserBean user) {
        try {
            sqlSession.insert("com.kachi.five.UserMapper.insertUser", user);
        } catch (DataAccessException e) {
            e.printStackTrace();
            System.out.println("Error Message: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

	@Override
	public UserBean getUser(String userID) throws Exception{
	    return sqlSession.selectOne("com.kachi.five.UserMapper.getUserID", userID);
	}
    @Override
    public List<UserBean> getAllUsers() throws Exception{
        return sqlSession.selectList("com.kachi.five.UserMapper.GetAllUsers");
        
    }
   
    
    @Override
    public void updateNickname(UserBean user) {
        try {
            sqlSession.update("com.kachi.five.UserMapper.updateNickname", user);
        } catch (DataAccessException e) {
            e.printStackTrace();
            System.out.println("Error Message: " + e.getMessage());
        }
    }
    @Override
    public void insertAddress(AddressBean address) {
    	 try {
             sqlSession.insert("com.kachi.five.UserMapper.insertAddress", address);
         } catch (DataAccessException e) {
             e.printStackTrace();
             System.out.println("Error Message: " + e.getMessage());
         }
    	
    	
    }
    @Override
    public List<AddressBean> getAddresses(String userId) {
    	return sqlSession.selectList("com.kachi.five.UserMapper.getAddresses", userId);
    }
    
    @Override 
    public void deleteAddress(int addressId) { 
       sqlSession.delete("com.kachi.five.UserMapper.deleteAddress", addressId); 
    }

	@Override
	public void deleteUser(int userId) {
		
		sqlSession.delete("com.kachi.five.UserMapper.deleteUser", userId); 
	}

	@Override
	public void updateUserPermission(UserBean user) throws Exception {
		 try {
		        sqlSession.update("com.kachi.five.UserMapper.updateUserPermission", user);
		    } catch (Exception e) {
		        e.printStackTrace();
		        System.out.println("Error Message: " + e.getMessage());
		        throw new RuntimeException(e);
		    }
		
	} 
    
}
