package com.kachi.five.DAO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kachi.five.bean.SearchHistoryBean;
@Repository
public class SearchDAOImpl implements SearchDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void insertSearchHistory(String userId, String keyword) { //회성 사용성으로 map 을 이용해서 값을 넣는다. 
	    sqlSession.insert("com.kachi.five.SearchMapper.insertSearchHistory", Map.of("userId", userId, "keyword", keyword));
	}

	    @Override
	    public void updateSearchCount(String keyword) {
	        sqlSession.update("com.kachi.five.SearchMapper.updateSearchCount", keyword);
	    }

	    @Override
	    public void deleteSearchHistoryById(int searchId) {
	        sqlSession.delete("com.kachi.five.SearchMapper.deleteSearchHistoryById", searchId);
	    }

	    @Override
	    public void deleteAllSearchHistory(String userId) {
	        sqlSession.delete("com.kachi.five.SearchMapper.deleteAllSearchHistory",userId);
	    }

	    @Override
	    public boolean checkExistingSearchHistory(String userId, String keyword) {
	        Integer count = sqlSession.selectOne("com.kachi.five.SearchMapper.checkExistingSearchHistory", Map.of("userId", userId, "keyword", keyword));
	        return count != null && count > 0;
	    }

	    @Override
	    public void updateSearchHistory(String userId, String keyword) {
	        sqlSession.update("com.kachi.five.SearchMapper.updateSearchHistory", Map.of("userId", userId, "keyword", keyword));
	    }

	    @Override
	    public List<SearchHistoryBean> getRecentSearchHistory(String userId) {
	        return sqlSession.selectList("com.kachi.five.SearchMapper.getRecentSearchHistory", userId);
	    }

	    @Override
	    public List<String> getPopularSearchKeywords() {
	        return sqlSession.selectList("com.kachi.five.SearchMapper.getPopularSearchKeywords");
	    }

		@Override
		public boolean checkExistingSearchCount(String keyword) {
			 Integer count = sqlSession.selectOne("com.kachi.five.SearchMapper.checkExistingSearchCount", keyword);
			    return count != null && count > 0;
		}

		@Override
		public void insertSearchCount(String keyword) {
			 sqlSession.insert("com.kachi.five.SearchMapper.insertSearchCount", keyword);
			
		}

	    
	}
	    


