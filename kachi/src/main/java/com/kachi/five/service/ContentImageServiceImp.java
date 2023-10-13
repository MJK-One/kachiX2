package com.kachi.five.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kachi.five.DAO.ContentImagesDAO;
import com.kachi.five.bean.ContentImageBean;
@Service
public class ContentImageServiceImp implements ContentImageService {
	 @Autowired 
	 private ContentImagesDAO contentImgDao; 

	@Override
	public void insertContentImage(ContentImageBean contentImg) {
		 contentImgDao.insertContentImages(contentImg);
	}
	 @Override
	    public void updateContentImagesWithPostId(int tempPostId, int actualPostId) {
	        contentImgDao.updateContentImagesWithPostId(tempPostId, actualPostId);
	    }

}
