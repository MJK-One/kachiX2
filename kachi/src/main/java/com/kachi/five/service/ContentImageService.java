package com.kachi.five.service;

import java.util.List;

import com.kachi.five.bean.ContentImageBean;

public interface ContentImageService {
	 public void insertContentImage(ContentImageBean contentImg);
	 void updateContentImagesWithPostId(int tempPostId, int actualPostId);
	 List<ContentImageBean> getContentImagesByPostId(int postId);
}
