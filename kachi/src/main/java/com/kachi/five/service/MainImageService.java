package com.kachi.five.service;

import com.kachi.five.bean.MainImageBean;

public interface MainImageService {
	void insertMainImage(MainImageBean mainImg);
	MainImageBean getMainImageByPostId(int postId);
}
