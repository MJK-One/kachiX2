package com.kachi.five.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kachi.five.DAO.PostDAO;
import com.kachi.five.bean.PostBean;

@Service
public class PostServiceImpl implements PostService {

	@Autowired 
	private PostDAO postDAO;

	public void createPost(PostBean post) {
		postDAO.insertPost(post);
	}
}
