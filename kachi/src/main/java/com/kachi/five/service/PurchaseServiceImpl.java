package com.kachi.five.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kachi.five.DAO.PurchaseDAO;
import com.kachi.five.bean.PurchaseBean;
@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseDAO purchaseDAO;
    
	@Override
	public void createPurchase(PurchaseBean purchase) {
		 purchaseDAO.createPurchase(purchase);
	}

}
