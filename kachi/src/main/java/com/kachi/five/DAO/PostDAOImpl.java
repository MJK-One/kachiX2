package com.kachi.five.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.kachi.five.bean.MainImageBean;
import com.kachi.five.bean.PostBean;

@Repository
public class PostDAOImpl implements PostDAO {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void insertPost(PostBean post) {
		 
		  try {
			    sqlSession.insert("com.kachi.five.PostMapper.insertPost", post);
			    System.out.println("생성된 게시물 ID: " + post.getPostId());
	        } catch (DataAccessException e) {
	            e.printStackTrace();
	            System.out.println("Error Message: " + e.getMessage());
	        }
	}
	@Override
	public List<PostBean> getAllPosts(){
		//데이터 베이스에 게시글이 있는 만큼 List에 가져옴
	    List<PostBean> posts = sqlSession.selectList("com.kachi.five.PostMapper.getAllPosts");

	    return posts;
	}
	@Override 
	public PostBean getPostById(int id) { 
	  PostBean post = sqlSession.selectOne("com.kachi.five.PostMapper.getPostsByID", id); 
	  MainImageBean mainImage = sqlSession.selectOne("com.kachi.five.ImageMapper.getMainImgByPostId", post.getPostId());
	  if (mainImage != null) {
		    post.setMainImageUrl(mainImage.getImageUrl());
		  }
		  return post;
	} 
	@Override
	 public void deletePost(int postId) {
		 sqlSession.delete("com.kachi.five.PostMapper.deletePost",postId);
		 
	 }
	@Override
	public List<PostBean> findPostsByTitleContaining(String query) {
		return sqlSession.selectList("com.kachi.five.PostMapper.findPostsByTitleContaining", query);
	}
	@Override
	public List<PostBean> getAllPostsOrderBySalePeriod() {
	    return sqlSession.selectList("com.kachi.five.PostMapper.getAllPostsOrderBySalePeriod");
	}
	@Override
	public List<PostBean> getAllPostsOrderBydiscountRate() {
	    return sqlSession.selectList("com.kachi.five.PostMapper.getAllPostsOrderBydiscountRate");
	}
	@Override
	public List<PostBean> getAllPostsOrderByrecent() {
	    return sqlSession.selectList("com.kachi.five.PostMapper.getAllPostsOrderByrecent");
	}
	@Override
	public List<PostBean> getAllPostsOrderByrating() {
		
		return sqlSession.selectList("com.kachi.five.PostMapper.getAllPostsOrderByrating");
	}
	
}
