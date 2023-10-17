package com.kachi.five.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class WishlistDAOImpl implements WishlistDAO {
   @Autowired
    private SqlSession sqlSession;
	@Override
	public void addToWishlist(String userId, int postId) {
		 // Wishlist 테이블에 userId와 postId를 추가하는 SQL 구문을 실행
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        params.put("postId", postId);
        sqlSession.insert("com.kachi.five.WishlistMapper.insertWishlist", params);

	}

	@Override
	public void removeFromWishlist(String userId, int postId) {
		 // Wishlist 테이블에서 userId와 postId를 삭제하는 SQL 구문을 실행
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        params.put("postId", postId);
        sqlSession.delete("com.kachi.five.WishlistMapper.deleteWishlist", params);


	}

	@Override
	public List<Integer> getWishlistByUser(String userId) {
		 // 특정 사용자의 찜한 게시물 목록을 가져오는 SQL 구문을 실행
        return sqlSession.selectList("com.kachi.five.WishlistMapper.getWishlistByUser", userId);

	}

	@Override
	public boolean isPostInWishlist(String userId, int postId) {
	    Map<String, Object> params = new HashMap<>(); 
	    params.put("userId",userId); 
	    params.put("postId",postId); 
	    Boolean isInWishlist = sqlSession.selectOne("com.kachi.five.WishlistMapper.isInWishlist", params); 

	    return isInWishlist != null && isInWishlist;
	}
	
}
