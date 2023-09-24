package com.kachi.five.DAO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kachi.five.bean.UserBean;

@Repository
public class UserDAOimpl implements UserDAO {
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void insertUser(UserBean user) {
		// TODO Auto-generated method stub
		   sqlSession.insert("com.kachi.five.UserMapper.insertUser", user);
	}

}
