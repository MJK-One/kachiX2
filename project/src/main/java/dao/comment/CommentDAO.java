package dao.comment;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.comment.CommentVO;

public class CommentDAO {
	private SqlSession sqlSession;
	
	public CommentDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<CommentVO> selectList(Map<String, Object> map){
		return sqlSession.selectList("link.selectList", map);
	}
	
	public CommentVO selectOne(int seq) {
		return sqlSession.selectOne("comment.selectOne",seq);
	}
	
	public int insert(CommentVO vo) {
		return sqlSession.insert("comment.insert",vo);
	}
	
	public int delete(int seq) {
		return sqlSession.delete("comment.delete",seq);
	}
	
	public int update(CommentVO vo) {
		return sqlSession.update("comment.update",vo);
	}

}
