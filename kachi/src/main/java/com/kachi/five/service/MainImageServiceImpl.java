package com.kachi.five.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kachi.five.DAO.MainImageDAO;
import com.kachi.five.bean.MainImageBean;

@Service
public class MainImageServiceImpl implements MainImageService {
	@Autowired 
    private MainImageDAO mainImgDao; 
	
	@Override
	public void insertMainImage(MainImageBean mainImg) {
		mainImgDao.insertMainImage(mainImg);

	}

	@Override
	public MainImageBean getMainImageByPostId(int postId) {
		
		return mainImgDao.getMainImageByPostId(postId);
	}

}
