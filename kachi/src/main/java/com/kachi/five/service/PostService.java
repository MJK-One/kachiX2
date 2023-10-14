package com.kachi.five.service;

import java.util.List;

import com.kachi.five.bean.PostBean;

public interface PostService {
	public void createPost(PostBean post);
	public List<PostBean> getAllPosts();
	public PostBean getPostById(int postId);
	public void deletePost(int postId);
}
