package com.kachi.five.DAO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kachi.five.bean.PurchaseBean;
@Repository
public class PurchaseDAOImpl implements PurchaseDAO {
	 @Autowired
	 private SqlSession sqlSession;
	 
	@Override
	public void createPurchase(PurchaseBean purchase) {
		  sqlSession.insert("com.kachi.five.PurchaseMapper.insertPurchase", purchase);
	}

}
