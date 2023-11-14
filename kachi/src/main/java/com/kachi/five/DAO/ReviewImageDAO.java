package com.kachi.five.DAO;


import com.kachi.five.bean.ReviewImageBean;

public interface ReviewImageDAO {

	public void insertReviewImage(ReviewImageBean reviewImage);
	public ReviewImageBean getReviewImageByReviewId(int reviewId);
}
