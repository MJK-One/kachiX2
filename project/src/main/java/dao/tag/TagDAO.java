package dao.tag;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.link.LinkVO;
import vo.tag.TagVO;

public class TagDAO {
	private SqlSession sqlSession;
	
	public TagDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<TagVO> selectList(Map<String, Object> map){
		return sqlSession.selectList("tag.selectList", map);
	}
	
	public TagVO selectOne(int seq) {
		return sqlSession.selectOne("tag.selectOne",seq);
	}
	
	public int insert(TagVO vo) {
		return sqlSession.insert("tag.insert",vo);
	}
	
	public int delete(int seq) {
		return sqlSession.delete("tag.delete",seq);
	}
	
	public int update(TagVO vo) {
		return sqlSession.update("tag.update",vo);
	}

}
