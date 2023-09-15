package dao.refund;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.refund.RefundVO;

public class RefundDAO {

	private SqlSession sqlSession;
	
	public RefundDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<RefundVO> selectList(Map<String, Object> map){
		return sqlSession.selectList("refund.selectList",map);
	}
	
	public RefundVO selectOne(int idx) {
		return sqlSession.selectOne("refund.selectOne",idx);
	}
	
	public int insert(RefundVO vo) {
		return sqlSession.insert("refund.insert",vo);
	}
	
	public int delete(int idx) {
		return sqlSession.delete("refund.delete",idx);
	}
	
	public int update(RefundVO vo) {
		return sqlSession.update("refund.update",vo);
	}
}
