package com.kachi.five.DAO;

import java.util.List;

import com.kachi.five.bean.ContentImageBean;

public interface ContentImagesDAO {
	 public void insertContentImages(ContentImageBean contentImg);
	 void updateContentImagesWithPostId(int tempPostId, int actualPostId);
	 List<ContentImageBean> getContentImagesByPostId(int postId);
}
