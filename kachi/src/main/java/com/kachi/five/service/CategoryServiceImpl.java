package com.kachi.five.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kachi.five.DAO.CategoryDAO;
import com.kachi.five.bean.CategoryBean;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired 
	private CategoryDAO categoryDAO; 
	
	@Override
	public List<CategoryBean> getAllCategories() { 
		return categoryDAO.getAllCategories(); 
	} 

}
