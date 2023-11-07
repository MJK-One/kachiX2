package com.kachi.five.DAO;

import java.util.List;

import com.kachi.five.bean.GroupBuyBean;

public interface GroupBuyDAO {
	public GroupBuyBean getGroupBuy(int groupBuyID);
	public void createGroupBuy(GroupBuyBean groupBuy);
	public void updateGroupBuy(GroupBuyBean groupBuy);
	public List<GroupBuyBean> getGroupBuysByPostId(int postId);
}
