package com.kachi.five.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kachi.five.bean.PostBean;
import com.kachi.five.bean.PurchaseBean;
@Repository
public class PurchaseDAOImpl implements PurchaseDAO {
	 @Autowired
	 private SqlSession sqlSession;
	 
	@Override
	public void createPurchase(PurchaseBean purchase) {
		  sqlSession.insert("com.kachi.five.PurchaseMapper.insertPurchase", purchase);
	}

	@Override
	public List<PurchaseBean> getPurchaseCompletedGroupBuy() {
		List<PurchaseBean> purchases = sqlSession.selectList("com.kachi.five.PurchaseMapper.selectPurchasesByCompletedGroupBuy");
		return purchases;
	}

	@Override
	public void updateDeliveryStatus(int purchaseId) {
		sqlSession.update("com.kachi.five.PurchaseMapper.updateDeliveryStatus", purchaseId);
	}

	@Override
	public List<PurchaseBean> getPurchasesByUserID(String userID) {
		List<PurchaseBean> posts = sqlSession.selectList("com.kachi.five.PurchaseMapper.selectPurchasesByUserID",userID);
		return posts;
	}
	

}
