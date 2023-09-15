package dao.brandcategory;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.brandcategory.BrandCategoryVO;

public class BrandCategoryDAO {
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<BrandCategoryVO> selectList(Map<String, Object> map){
		return sqlSession.selectList("brand_category.selectList",map);
	}
	
	public BrandCategoryVO selectOne(int seq) {
		return sqlSession.selectOne("brand_category.selectOne",seq);
	}
	public int insert(BrandCategoryVO vo) {
		return sqlSession.insert("brand_category.insert",vo);
	}
	
	public int delete(int seq) {
		return sqlSession.delete("brand_category.delete",seq);
	}
	
	public int update(BrandCategoryVO vo) {
		return sqlSession.update("brand_category.update",vo);
	}

}
