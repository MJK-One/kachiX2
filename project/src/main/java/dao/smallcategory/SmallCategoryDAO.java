package dao.smallcategory;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.link.LinkVO;
import vo.middlecategory.MiddleCategoryVO;
import vo.smallcategory.SmallCategoryVO;

public class SmallCategoryDAO {
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<SmallCategoryVO> selectName(int idx){
		return sqlSession.selectList("smallcategory.selectName", idx);
	}
	
	public int insert(SmallCategoryVO vo) {
		return sqlSession.insert("smallcategroy.insert",vo);
	}
	
	public int delete(int seq) {
		return sqlSession.delete("smallcategroy.delete",seq);
	}
	
	public int update(SmallCategoryVO vo) {
		return sqlSession.update("smallcategroy.update",vo);
	}

}
