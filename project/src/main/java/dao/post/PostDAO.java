package dao.post;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.link.LinkVO;
import vo.post.PostVO;
import vo.postcategory.PostCategoryVO;
import vo.postproduct.PostProductVO;

public class PostDAO {

	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int selectCntP(int idx) {
		return sqlSession.selectOne("post.selectCntP", idx);
	}
	
	public int selectCntH(int idx) {
		return sqlSession.selectOne("post.selectCntH", idx);
	}
	
	public List<PostVO> selectList(String kind){
		return sqlSession.selectList("post.selectList", kind);
	}
	
	public List<PostVO> selectMy(int idx){
		return sqlSession.selectList("post.selectMy", idx);
	}
	public PostVO selectOne(int idx) {
		return sqlSession.selectOne("post.selectOne",idx);
	}
	
	public int readCount(int idx) {
		return sqlSession.update("post.readCount",idx);
	}
	
	public Map<String, Object> getContent(int idx){
		return sqlSession.selectOne("post.getContent", idx);
	}
	
	public int insert(PostVO vo) {
		return sqlSession.insert("post.insert",vo);
	}
	
	public int delete(int idx) {
		return sqlSession.delete("post.delete",idx);
	}
	
	public int update(PostVO vo) {
		return sqlSession.update("post.update",vo);
	}
	
	public int getIdx() {
		return sqlSession.selectOne("post.getIdx");
	}
}