package dao.postproduct;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.link.LinkVO;
import vo.postcategory.PostCategoryVO;
import vo.postproduct.PostProductVO;

public class PostProductDAO {
	private SqlSession sqlSession;
	
	public PostProductDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<PostProductVO> selectList(Map<String, Object> map){
		return sqlSession.selectList("postproduct.selectList", map);
	}
	
	public PostProductVO selectOne(int seq) {
		return sqlSession.selectOne("postproduct.selectOne",seq);
	}
	
	public int insert(PostProductVO vo) {
		return sqlSession.insert("postproduct.insert",vo);
	}
	
	public int delete(int seq) {
		return sqlSession.delete("postproduct.delete",seq);
	}
	
	public int update(PostProductVO vo) {
		return sqlSession.update("postproduct.update",vo);
	}

}
