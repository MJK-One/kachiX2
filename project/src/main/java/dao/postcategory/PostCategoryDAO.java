package dao.postcategory;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.link.LinkVO;
import vo.postcategory.PostCategoryVO;

public class PostCategoryDAO {
	private SqlSession sqlSession;
	
	public PostCategoryDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<PostCategoryVO> selectList(Map<String, Object> map){
		return sqlSession.selectList("postcategroy.selectList", map);
	}
	
	public PostCategoryVO selectOne(int seq) {
		return sqlSession.selectOne("postcategroy.selectOne",seq);
	}
	
	public int insert(PostCategoryVO vo) {
		return sqlSession.insert("postcategroy.insert",vo);
	}
	
	public int delete(int seq) {
		return sqlSession.delete("postcategroy.delete",seq);
	}
	
	public int update(PostCategoryVO vo) {
		return sqlSession.update("postcategroy.update",vo);
	}

}
