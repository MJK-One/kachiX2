package com.kachi.five.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.kachi.five.bean.ReviewBean;
@Repository
public class ReviewDAOImpl implements ReviewDAO {

	@Autowired
	private SqlSession sqlSession;
	@Override
	public void insertReview(ReviewBean review) {
		 try {
			    sqlSession.insert("com.kachi.five.ReviewMapper.insertReview", review);
			
	        } catch (DataAccessException e) {
	            e.printStackTrace();
	            System.out.println("Error Message: " + e.getMessage());
	        }


	}
	@Override
	public List<ReviewBean> getReviewsByPostId(int postID) {
		return sqlSession.selectList("com.kachi.five.ReviewMapper.getReviewsByPostId",postID);
		
	}

}
