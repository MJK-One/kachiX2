package com.kachi.five.service;

import java.util.List;

import com.kachi.five.bean.PurchaseBean;

public interface PurchaseService {
	public void createPurchase(PurchaseBean purchase);
	public List<PurchaseBean> getPurchaseCompletedGroupBuy();
	void updateDeliveryStatus(int purchaseId);
}
