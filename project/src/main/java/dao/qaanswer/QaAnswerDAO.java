package dao.qaanswer;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.qaanswer.QaAnswerVO;

public class QaAnswerDAO {

	private SqlSession sqlSession;
	
	public QaAnswerDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<QaAnswerVO> selectList(Map<String, Object> map){
		return sqlSession.selectList("qa_answer.selectList",map);
	}
	
	public QaAnswerVO selectOne(int seq) {
		return sqlSession.selectOne("qa_answer.selectOne",seq);
	}
	public int insert(QaAnswerVO vo) {
		return sqlSession.insert("qa_answer.insert",vo);
	}
	
	public int delete(int seq) {
		return sqlSession.delete("qa_answer.delete",seq);
	}
	
	public int update(QaAnswerVO vo) {
		return sqlSession.update("qa_answer.update",vo);
	}

}
