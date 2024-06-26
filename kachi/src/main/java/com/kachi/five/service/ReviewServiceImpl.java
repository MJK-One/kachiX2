package com.kachi.five.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kachi.five.DAO.ReviewDAO;
import com.kachi.five.bean.ReviewBean;
@Service
public class ReviewServiceImpl implements ReviewService {
	@Autowired
	private ReviewDAO reviewDAO;
	@Override
	public void insertReview(ReviewBean review) {
		reviewDAO.insertReview(review);

	}
	@Override
	public List<ReviewBean> getReviewsByPostId(int postID) {
		
		return reviewDAO.getReviewsByPostId(postID);
	}
	
}
