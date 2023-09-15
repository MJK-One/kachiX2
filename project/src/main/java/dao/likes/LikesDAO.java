package dao.likes;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.likes.LikesVO;
import vo.scrap.ScrapVO;

public class LikesDAO {
	private SqlSession sqlSession;
	
	public int check(Map<String, Object> map){
		Integer check = sqlSession.selectOne("likes.check",map);
		
		if(check == null) {
			check = 0;
		}
		
		return check;
	}
	
	public int likesMCnt(int idx) {
		return sqlSession.selectOne("likes.likesMCnt", idx);
	}
	
	public int likesPCnt(int idx) {
		return sqlSession.selectOne("likes.likesPCnt", idx);
	}
	
	public List<LikesVO> selectList(int idx){
		return sqlSession.selectList("likes.selectList", idx);
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(LikesVO vo) {
		return sqlSession.insert("likes.insert",vo);
	}
	
	public int delete(Map<String, Object> map) {
		return sqlSession.delete("likes.delete",map);
	}
	
	public int update(LikesVO vo) {
		return sqlSession.update("likes.update",vo);
	}

}
