package com.kachi.five.DAO;

import java.util.List;

import com.kachi.five.bean.SearchHistoryBean;

public interface SearchDAO {
	public void insertSearchHistory(String userId, String Keyword);
	public void updateSearchCount(String keyword);
	public void deleteSearchHistoryById(int searchId);
	public void deleteAllSearchHistory(String userId);
 	public boolean checkExistingSearchHistory(String userId, String keyword);
    public void updateSearchHistory(String userId, String keyword);
    public List<SearchHistoryBean> getRecentSearchHistory(String userId);
    public List<String> getPopularSearchKeywords();
    public boolean checkExistingSearchCount(String keyword);
    public void insertSearchCount(String keyword);
    
}
