package com.kachi.five.service;

import com.kachi.five.bean.ReviewImageBean;

public interface ReviewImageService {
	public void insetReviewImage(ReviewImageBean reviewImg);
	public ReviewImageBean getReviewImageByReviewId(int reviewId);
}
