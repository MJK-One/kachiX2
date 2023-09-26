package com.kachi.five.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kachi.five.bean.CategoryBean;
@Repository
public class CategoryDAOImpl implements CategoryDAO {
	@Autowired
	SqlSession sqlSession;
	@Override
	public List<CategoryBean> getAllCategories() {
	      return sqlSession.selectList("com.kachi.five.CategoryMapper.getAllCategories");
	}

}
