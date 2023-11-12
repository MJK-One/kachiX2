package com.kachi.five.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kachi.five.bean.GroupBuyBean;
@Repository
public class GroupBuyDAOImpl implements GroupBuyDAO {
	@Autowired
	SqlSession sqlSession;
	@Override
	public GroupBuyBean getGroupBuy(int groupBuyID) {
		return sqlSession.selectOne("com.kachi.five.GroupBuyMapper.getGroupBuy", groupBuyID);
	}

	@Override
	public GroupBuyBean createGroupBuy(GroupBuyBean groupBuy) {
	    sqlSession.insert("com.kachi.five.GroupBuyMapper.createGroupBuy", groupBuy);
	    return groupBuy;
	}

	@Override
	public int updateGroupBuy(GroupBuyBean groupBuy) {
		return sqlSession.update("com.kachi.five.GroupBuyMapper.updateGroupBuy", groupBuy);

	}

	@Override
	public List<GroupBuyBean> getGroupBuysByPostId(int postId) {
		return sqlSession.selectList("com.kachi.five.GroupBuyMapper.getGroupBuysByPostId", postId);
	}

}
