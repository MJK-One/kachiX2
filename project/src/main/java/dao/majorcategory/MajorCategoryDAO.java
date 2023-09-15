package dao.majorcategory;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.majorcategory.MajorCategoryVO;

public class MajorCategoryDAO {
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<MajorCategoryVO> selectName(String kind){
		return sqlSession.selectList("majorcategory.selectName", kind);
	}
	
	public MajorCategoryVO selectOne(int idx){
		return sqlSession.selectOne("majorcategory.selectOne", idx);
	}
	
	public int insert(MajorCategoryVO vo) {
		return sqlSession.insert("majorcategory.insert",vo);
	}
	
	public int delete(int seq) {
		return sqlSession.delete("majorcategory.delete",seq);
	}
	
	public int update(MajorCategoryVO vo) {
		return sqlSession.update("majorcategory.update",vo);
	}
	
	

}
