package com.kachi.five.service;

import com.kachi.five.bean.UserBean;

public interface NaverLoginService {
		String getAccessToken(String code, String state) throws Exception;
	    UserBean getUserProfile(String accessToken) throws Exception;
	    void insertUser(UserBean user) throws Exception;
}
