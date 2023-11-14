package com.kachi.five.service;

import java.util.List;

import com.kachi.five.bean.ReviewBean;

public interface ReviewService {
	public void insertReview(ReviewBean review);
	public List<ReviewBean> getReviewsByPostId(int postID);
}
