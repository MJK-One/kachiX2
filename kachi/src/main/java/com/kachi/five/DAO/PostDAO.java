package com.kachi.five.DAO;

import java.util.List;

import com.kachi.five.bean.PostBean;

public interface PostDAO {
	 public void insertPost(PostBean post);
	 public List<PostBean> getAllPosts();
	 public PostBean getPostById(int postId);
	 public void deletePost(int postId);
	 public List<PostBean> findPostsByTitleContaining(String query);
	 public List<PostBean> getAllPostsOrderBySalePeriod();
	 public List<PostBean> getAllPostsOrderBydiscountRate();
	 public List<PostBean> getAllPostsOrderByrecent();
	 public List<PostBean> getAllPostsOrderByrating();
}
