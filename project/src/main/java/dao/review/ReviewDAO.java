package dao.review;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.review.ReviewVO;

public class ReviewDAO {

	private SqlSession sqlSession;
	
	public ReviewDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<ReviewVO> selectList(Map<String, Object> map){
		return sqlSession.selectList("review.selectList",map);
	}
	
	public ReviewVO selectOne(int idx) {
		return sqlSession.selectOne("review.selectOne",idx);
	}
	
	public int insert(ReviewVO vo) {
		return sqlSession.insert("review.insert",vo);
	}
	
	public int delete(int idx) {
		return sqlSession.delete("review.delete",idx);
	}
	
	public int update(ReviewVO vo) {
		return sqlSession.update("review.update",vo);
	}
	
}
