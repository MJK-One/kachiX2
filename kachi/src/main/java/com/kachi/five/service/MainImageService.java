package com.kachi.five.service;

import com.kachi.five.bean.MainImageBean;

public interface MainImageService {
	public void insertMainImage(MainImageBean mainImg);
	public MainImageBean getMainImageByPostId(int postId);
}
