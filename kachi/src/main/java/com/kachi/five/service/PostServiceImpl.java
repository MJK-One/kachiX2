package com.kachi.five.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kachi.five.DAO.PostDAO;
import com.kachi.five.bean.PostBean;

@Service
public class PostServiceImpl implements PostService {

	@Autowired 
	private PostDAO postDAO;
	
	@Override
	public void createPost(PostBean post) {
		postDAO.insertPost(post);
	}
	@Override
	public List<PostBean> getAllPosts(){
		return postDAO.getAllPosts();
	}
	@Override
	public PostBean getPostById(int postId){
	  return postDAO.getPostById(postId);
	}
	@Override
	public void deletePost(int postId) {
		postDAO.deletePost(postId);
	}
	@Override
	public List<PostBean> findPostsByTitleContaining(String query) {
		return postDAO.findPostsByTitleContaining(query);
	}
	@Override
    public List<PostBean> getAllPostsOrderBySalePeriod() {
        return postDAO.getAllPostsOrderBySalePeriod();
    }
	@Override
    public List<PostBean> getAllPostsOrderBydiscountRate() {
        return postDAO.getAllPostsOrderBydiscountRate();
    }
	@Override
    public List<PostBean> getAllPostsOrderByrecent() {
        return postDAO.getAllPostsOrderByrecent();
    }
	@Override
	public List<PostBean> getAllPostsOrderByrating() {
		return postDAO.getAllPostsOrderByrating();
	}
	
}
