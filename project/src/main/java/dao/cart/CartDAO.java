package dao.cart;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.cart.CartVO;

public class CartDAO {

	private SqlSession sqlSession;
	
	public CartDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<CartVO> selectList(Map<String, Object> map){
		return sqlSession.selectList("cart.selectList",map);
	}
	
	public CartVO selectOne(int idx) {
		return sqlSession.selectOne("cart.selectOne",idx);
	}
	
	public int insert(CartVO vo) {
		return sqlSession.insert("cart.insert",vo);
	}
	
	public int delete(int idx) {
		return sqlSession.delete("cart.delete",idx);
	}
	
	public int update(CartVO vo) {
		return sqlSession.update("cart.update",vo);
	}
}
