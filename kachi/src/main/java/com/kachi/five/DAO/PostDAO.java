package com.kachi.five.DAO;

import java.util.List;

import com.kachi.five.bean.PostBean;

public interface PostDAO {
	 public void insertPost(PostBean post);
	 public List<PostBean> getAllPosts();
}
