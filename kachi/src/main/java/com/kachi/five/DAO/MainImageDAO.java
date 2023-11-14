package com.kachi.five.DAO;

import com.kachi.five.bean.MainImageBean;

public interface MainImageDAO {
	 public void insertMainImage(MainImageBean mainImage);
	 public MainImageBean getMainImageByPostId(int postId);
}
