package com.kachi.five.service;

import java.util.List;

import com.kachi.five.bean.SearchHistoryBean;
import com.kachi.five.bean.SearchKeyword;

public interface SearchService {
	public void recordSearch(String userId, String keyword);
	public void deleteSearchHistoryById(List<String> searchId);
	public void deleteAllSearchHistory(String userId);
	public List<SearchHistoryBean> getRecentSearchHistory(String userId);
	public List<String> getPopularSearchKeywords();
	
}
