package dao.cancel;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.cancel.CancelVO;

public class CancelDAO {

	private SqlSession sqlSession;

	
	public CancelDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<CancelVO> selectList(Map<String, Object> map){
		return sqlSession.selectList("cancel.selectList",map);
	}
	
	public CancelVO selectOne(int idx) {
		return sqlSession.selectOne("cancel.selectOne",idx);
	}
	
	public int insert(CancelVO vo) {
		return sqlSession.insert("cancel.insert",vo);
	}
	
	public int delete(int idx) {
		return sqlSession.delete("cancel.delete",idx);
	}
	
	public int update(CancelVO vo) {
		return sqlSession.update("cancel.update",vo);
	}
}
