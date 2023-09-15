package dao.link;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.link.LinkVO;

public class LinkDAO {
	private SqlSession sqlSession;
	
	public LinkDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<LinkVO> selectList(Map<String, Object> map){
		return sqlSession.selectList("link.selectList", map);
	}
	
	public LinkVO selectOne(int seq) {
		return sqlSession.selectOne("link.selectOne",seq);
	}
	
	public int insert(LinkVO vo) {
		return sqlSession.insert("link.insert",vo);
	}
	
	public int delete(int seq) {
		return sqlSession.delete("link.delete",seq);
	}
	
	public int update(LinkVO vo) {
		return sqlSession.update("link.update",vo);
	}

}
