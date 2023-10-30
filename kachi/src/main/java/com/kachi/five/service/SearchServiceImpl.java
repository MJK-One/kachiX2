package com.kachi.five.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kachi.five.DAO.SearchDAO;
import com.kachi.five.bean.SearchHistoryBean;
@Service
public class SearchServiceImpl implements SearchService {

	 @Autowired 
	 private SearchDAO searchDAO;
	 
	 @Override
	 public void recordSearch(String userId, String keyword) {
	     if (searchDAO.checkExistingSearchHistory(userId, keyword)) { //사용자가 검색한적이 있는 검색어인지 확인
	         searchDAO.updateSearchHistory(userId, keyword); //검색한적 있으면 검색 날짜만 바꿈
	     } else {
	         searchDAO.insertSearchHistory(userId, keyword);	//검색한 적이 없다면 값을 넣음
	     }

	     if (searchDAO.checkExistingSearchCount(keyword)) { //모든 사용자에게 검색된 적이 있는 키워드 인지 확인
	         searchDAO.updateSearchCount(keyword); //검색이 되어 있었다면 검색횟수 추가
	     } else {
	         searchDAO.insertSearchCount(keyword); //처음 검색된 검색어라면 값을 넣음
	     }
	 }
	  @Override
	    public void deleteSearchHistoryById(List<String> searchId) {
	        for (String id : searchId) {
	            searchDAO.deleteSearchHistoryById(Integer.parseInt(id));
	        }
	    }

	    @Override
	    public void deleteAllSearchHistory(String userId) {
	        searchDAO.deleteAllSearchHistory(userId);
	    }

	    @Override
	    public List<SearchHistoryBean> getRecentSearchHistory(String userId) {
	        return searchDAO.getRecentSearchHistory(userId);
	    }

	    @Override
	    public List<String> getPopularSearchKeywords() {
	        return searchDAO.getPopularSearchKeywords();
	    }
	    

}
