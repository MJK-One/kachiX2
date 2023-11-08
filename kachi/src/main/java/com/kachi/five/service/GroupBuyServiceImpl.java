package com.kachi.five.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kachi.five.DAO.GroupBuyDAO;
import com.kachi.five.bean.GroupBuyBean;
@Service
public class GroupBuyServiceImpl implements GroupBuyService {
	@Autowired
	GroupBuyDAO groupBuyDAO;
	@Override
	public GroupBuyBean getGroupBuy(int groupBuyID) {
		 return groupBuyDAO.getGroupBuy(groupBuyID);
	}

	@Override
	public void createGroupBuy(GroupBuyBean groupBuy) {
		 groupBuyDAO.createGroupBuy(groupBuy);
	}

	@Override
	public int updateGroupBuy(GroupBuyBean groupBuy) {
		return groupBuyDAO.updateGroupBuy(groupBuy);

	}

	@Override
	public List<GroupBuyBean> getGroupBuysByPostId(int postId) {
		 return groupBuyDAO.getGroupBuysByPostId(postId);
	}

}
