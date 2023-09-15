package dao.options;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.options.OptionsVO;

public class OptionsDAO {

	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<OptionsVO> selectList(Map<String, Object> map){
		return sqlSession.selectList("options.selectList",map);
	}
	
	public OptionsVO selectOne(int idx) {
		return sqlSession.selectOne("options.selectOne",idx);
	}
	
	public int insert(OptionsVO vo) {
		return sqlSession.insert("options.insert",vo);
	}
	
	public int delete(int idx) {
		return sqlSession.delete("options.delete",idx);
	}
	
	public int update(OptionsVO vo) {
		return sqlSession.update("options.update",vo);
	}
}
