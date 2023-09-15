package dao.productcategory;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.product.ProductVO;
import vo.productcategory.ProductcategoryVO;

public class ProductcategoryDAO {

	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		
	}
	
	public List<ProductcategoryVO> selectList(int idx){
		return sqlSession.selectList("productcategory.selectList", idx);
	}
	
	public int insert(ProductcategoryVO vo) {
		return sqlSession.insert("productcategory.insert",vo);
	}
	
	public int insert2(ProductcategoryVO vo) {
		return sqlSession.insert("productcategory.insert2",vo);
	}
	
	public int delete(int idx) {
		return sqlSession.delete("productcategory.delete",idx);
	}
	
	public int update(ProductcategoryVO vo) {
		return sqlSession.update("productcategory.update",vo);
	}
	
}
