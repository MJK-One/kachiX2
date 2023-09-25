package com.kachi.five.DAO;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

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
        }
    }

	@Override
	public UserBean getUser(String userID) throws Exception{
	    return sqlSession.selectOne("com.kachi.five.UserMapper.getUserID", userID);
	}
       
    public List<UserBean> test() throws Exception{
        return sqlSession.selectList("com.kachi.five.UserMapper.test");
        
    }
    @Override
    public int getWritePermission(String userID) throws Exception {
    	 return sqlSession.selectOne("com.kachi.five.UserMapper.getWritePermission", userID);
    }



}
