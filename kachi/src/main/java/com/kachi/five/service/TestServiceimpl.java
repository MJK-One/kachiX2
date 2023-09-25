package com.kachi.five.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kachi.five.DAO.UserDAO;
import com.kachi.five.bean.UserBean;

@Service
public class TestServiceimpl implements TestService {

	@Inject

	private UserDAO dao;

	

	@Override

	public List<UserBean> test() throws Exception {

		// TODO Auto-generated method stub

		return dao.test();

	}

}
