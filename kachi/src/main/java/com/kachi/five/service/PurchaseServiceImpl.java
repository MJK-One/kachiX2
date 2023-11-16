package com.kachi.five.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kachi.five.DAO.PurchaseDAO;
import com.kachi.five.bean.PostBean;
import com.kachi.five.bean.PurchaseBean;
@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseDAO purchaseDAO;
    
	@Override
	public void createPurchase(PurchaseBean purchase) {
		 purchaseDAO.createPurchase(purchase);
	}

	@Override
	public List<PurchaseBean> getPurchaseCompletedGroupBuy() {
		return purchaseDAO.getPurchaseCompletedGroupBuy();
	}

	@Override
	public void updateDeliveryStatus(int purchaseId) {
		purchaseDAO.updateDeliveryStatus(purchaseId);
		
	}

	@Override
	public List<PurchaseBean> getPurchasesByUserID(String userID) {
		return purchaseDAO.getPurchasesByUserID(userID);
	}

	@Override
	public void updatereviewWritten(int purchaseId) {
		purchaseDAO.updatereviewWritten(purchaseId);
		
	}

}
