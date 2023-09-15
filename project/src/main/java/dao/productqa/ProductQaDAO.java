package dao.productqa;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.productqa.ProductQaVO;

public class ProductQaDAO {

	private SqlSession sqlSession;
	
	public ProductQaDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<ProductQaVO> selectList(Map<String, Object> map){
		return sqlSession.selectList("product_qa.selectList",map);
	}
	
	public ProductQaVO selectOne(int seq) {
		return sqlSession.selectOne("product_qa.selectOne",seq);
	}
	public int insert(ProductQaVO vo) {
		return sqlSession.insert("product_qa.insert",vo);
	}
	
	public int delete(int seq) {
		return sqlSession.delete("product_qa.delete",seq);
	}
	
	public int update(ProductQaVO vo) {
		return sqlSession.update("product_qa.update",vo);
	}

}
