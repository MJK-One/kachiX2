package com.kachi.five.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

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
		
		return sqlSession.selectList("com.kachi.five.PostMapper.getAllPosts");
	}

}
