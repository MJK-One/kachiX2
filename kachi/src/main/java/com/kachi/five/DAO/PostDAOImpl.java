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
	    //게시글 수 만큼 게시글id로 게시글의 이미지를 가져옴
	    for (PostBean post : posts) {
	        MainImageBean mainImage = sqlSession.selectOne("com.kachi.five.ImageMapper.getMainImgByPostId", post.getPostId());
	        if (mainImage != null) {
	            post.setMainImageUrl(mainImage.getImageUrl());
	        }
	    }

	    return posts;
	}

}
