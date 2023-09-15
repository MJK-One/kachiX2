package dao.follow;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.follow.FollowVO;
import vo.post.PostVO;

public class FollowDAO {
private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int check(Map<String, Object> map){
		Integer check = sqlSession.selectOne("follow.check",map);
		
		if(check == null) {
			check = 0;
		}
		
		return check;
	}
	
	public int followCnt(int idx) {
		int i = sqlSession.selectOne("follow.followCnt", idx);
		System.out.println(i);
		return i;
	}
	
	public int followerCnt(int idx) {
		return sqlSession.selectOne("follow.followerCnt", idx);
	}
	
	public int insert(FollowVO vo) {
		return sqlSession.insert("follow.insert",vo);
	}
	
	public int delete(Map<String, Object> map) {
		return sqlSession.delete("follow.delete", map);
	}
	
	public int update(FollowVO vo) {
		return sqlSession.update("follow.update",vo);
	}

}
