package com.kachi.five.DAO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.kachi.five.bean.ReviewImageBean;
@Repository
public class ReviewImageDAOImpl implements ReviewImageDAO {
	@Autowired
	private SqlSession sqlSessionl;
	@Override
	public void insertReviewImage(ReviewImageBean reviewImage) {
		try {
			sqlSessionl.insert("com.kachi.five.ImageMapper.insertReviewImage",reviewImage);
		}catch (DataAccessException e) {
            e.printStackTrace();
            System.out.println("Error Message: " + e.getMessage());
		}

	}

	@Override
	public ReviewImageBean getReviewImageByReviewId(int reviewId) {
		ReviewImageBean reviewimage = sqlSessionl.selectOne("com.kachi.five.ImageMapper.getReviewImagesByReviewId");
		return reviewimage;
	}

}
