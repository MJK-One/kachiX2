package dao.product;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.product.ProductVO;

public class ProductDAO {

	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		
	}
	
	public List<ProductVO> selectList(){
		return sqlSession.selectList("product.selectList");
	}
	
	public ProductVO selectOne(int idx) {
		return sqlSession.selectOne("product.selectOne",idx);
	}
	
	public int insert(ProductVO vo) {
		return sqlSession.insert("product.insert",vo);
	}
	
	public int delete(int idx) {
		return sqlSession.delete("product.delete",idx);
	}
	
	public int update(ProductVO vo) {
		return sqlSession.update("product.update",vo);
	}
	
	public int getIdx() {
		return sqlSession.selectOne("product.getIdx");
	}
}
