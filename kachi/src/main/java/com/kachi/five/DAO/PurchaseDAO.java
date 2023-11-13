package com.kachi.five.DAO;

import java.util.List;

import com.kachi.five.bean.PurchaseBean;

public interface PurchaseDAO {
	public void createPurchase(PurchaseBean purchase);
	public List<PurchaseBean> getPurchaseCompletedGroupBuy();
	void updateDeliveryStatus(int purchaseId);
}
