package dao.qa;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.qa.QaVO;

public class QaDAO {

	private SqlSession sqlSession;
	
	public QaDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<QaVO> selectList(Map<String, Object> map){
		return sqlSession.selectList("qa.selectList",map);
	}
	
	public QaVO selectOne(int seq) {
		return sqlSession.selectOne("qa.selectOne",seq);
	}
	public int insert(QaVO vo) {
		return sqlSession.insert("qa.insert",vo);
	}
	
	public int delete(int seq) {
		return sqlSession.delete("qa.delete",seq);
	}
	
	public int update(QaVO vo) {
		return sqlSession.update("qa.update",vo);
	}

}
