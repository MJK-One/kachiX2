package dao.fqa;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.fqa.FqaVO;


public class FqaDAO {

	private SqlSession sqlSession;
	
	public FqaDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<FqaVO> selectList(Map<String, Object> map){
		return sqlSession.selectList("fqa.selectList",map);
	}
	
	public FqaVO selectOne(int seq) {
		return sqlSession.selectOne("fqa.selectOne",seq);
	}
	public int insert(FqaVO vo) {
		return sqlSession.insert("fqa.insert",vo);
	}
	
	public int delete(int seq) {
		return sqlSession.delete("fqa.delete",seq);
	}
	
	public int update(FqaVO vo) {
		return sqlSession.update("fqa.update",vo);
	}

}
