package dao.notmemorder;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.notmemorder.NotMemOrderVO;

public class NotMemOrderDAO {

	private SqlSession sqlSession;
	
	public NotMemOrderDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<NotMemOrderVO> selectList(Map<String, Object> map){
		return sqlSession.selectList("notmemorder.selectList",map);
	}
	
	public NotMemOrderVO selectOne(int idx) {
		return sqlSession.selectOne("notmemorder.selectOne",idx);
	}
	
	public int insert(NotMemOrderVO vo) {
		return sqlSession.insert("notmemorder.insert",vo);
	}
	
	public int delete(int idx) {
		return sqlSession.delete("notmemorder.delete",idx);
	}
	
	public int update(NotMemOrderVO vo) {
		return sqlSession.update("notmemorder.update",vo);
	}
	
}
