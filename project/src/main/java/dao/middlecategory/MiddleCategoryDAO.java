package dao.middlecategory;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.link.LinkVO;
import vo.majorcategory.MajorCategoryVO;
import vo.middlecategory.MiddleCategoryVO;

public class MiddleCategoryDAO {
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<MiddleCategoryVO> selectName(int idx){
		return sqlSession.selectList("middlecategory.selectName", idx);
	}
	
	public int insert(MiddleCategoryVO vo) {
		return sqlSession.insert("middlecategroy.insert",vo);
	}
	
	public int delete(int seq) {
		return sqlSession.delete("middlecategroy.delete",seq);
	}
	
	public int update(MiddleCategoryVO vo) {
		return sqlSession.update("middlecategroy.update",vo);
	}

}
