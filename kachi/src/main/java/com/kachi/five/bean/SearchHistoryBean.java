package com.kachi.five.bean;

import java.sql.Timestamp; 

public class SearchHistoryBean {
	  private int searchId;
	  private String userId;
	  private String keyword;
	  private Timestamp searchTime;
	public int getSearchId() {
		return searchId;
	}
	public void setSearchId(int searchId) {
		this.searchId = searchId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Timestamp getSearchTime() {
		return searchTime;
	}
	public void setSearchTime(Timestamp searchTime) {
		this.searchTime = searchTime;
	}
	  
	  
}
