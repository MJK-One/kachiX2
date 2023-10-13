package com.kachi.five.DAO;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.kachi.five.bean.ContentImageBean;
@Repository
public class ContentImagesDAOImpl implements ContentImagesDAO {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void insertContentImages(ContentImageBean contentImg) {
	     try {
	         sqlSession.insert("com.kachi.five.ImageMapper.insertContentImg", contentImg);
	     } catch (DataAccessException e) {
	         e.printStackTrace();
	         System.out.println("Error Message: " + e.getMessage());
	     }
	}
	  @Override
		public void updateContentImagesWithPostId(int tempPostId, int actualPostId) {
	        Map<String, Integer> params = new HashMap<>();
	        params.put("temp_post_id", tempPostId);
	        params.put("actual_post_id", actualPostId);

		    sqlSession.update("com.kachi.five.ImageMapper.updateContentImagesWithPostId", params);
		}
}
