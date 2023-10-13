package com.kachi.five.service;

import com.kachi.five.bean.ContentImageBean;

public interface ContentImageService {
	 public void insertContentImage(ContentImageBean contentImg);
	 void updateContentImagesWithPostId(int tempPostId, int actualPostId);
}
