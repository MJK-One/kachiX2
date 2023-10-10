package com.kachi.five.DAO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.kachi.five.bean.MainImageBean;

@Repository
public class MainImageDAOImpl implements MainImageDAO {


		
		@Autowired
		SqlSession sqlSession;
		
		@Override
		public void insertMainImage(MainImageBean mainImage) {
			 
			  try {
				    sqlSession.insert("com.kachi.five.ImageMapper.insertMainImg", mainImage);
		        } catch (DataAccessException e) {
		            e.printStackTrace();
		            System.out.println("Error Message: " + e.getMessage());
		        }
		}
}
	


