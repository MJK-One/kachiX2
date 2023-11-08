package com.kachi.five.service;

import java.util.List;

import com.kachi.five.bean.GroupBuyBean;

public interface GroupBuyService {
	public GroupBuyBean getGroupBuy(int groupBuyID);
	public void createGroupBuy(GroupBuyBean groupBuy);
	public int updateGroupBuy(GroupBuyBean groupBuy);
	public List<GroupBuyBean> getGroupBuysByPostId(int postId);
}
