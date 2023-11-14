package com.kachi.five.DAO;



import java.util.List;

import com.kachi.five.bean.ReviewBean;


public interface ReviewDAO {
	public void insertReview(ReviewBean review);
	public List<ReviewBean> getReviewsByPostId(int postID);
}
