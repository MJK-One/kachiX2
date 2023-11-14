package com.kachi.five.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kachi.five.DAO.ReviewImageDAO;
import com.kachi.five.bean.ReviewImageBean;
@Service
public class ReviewImageServiceImpl implements ReviewImageService {
	@Autowired
	private ReviewImageDAO reviewimageDAO;
	
	@Override
	public void insetReviewImage(ReviewImageBean reviewImg) {
		reviewimageDAO.insertReviewImage(reviewImg);
		
	}

	@Override
	public ReviewImageBean getReviewImageByReviewId(int reviewId) {
		
		return reviewimageDAO.getReviewImageByReviewId(reviewId);
	}

	

}
