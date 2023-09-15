package dao.orderproduct;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.orderproduct.OrderProductVO;

public class OrderProductDAO {
	
	private SqlSession sqlSession;
	
	public OrderProductDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<OrderProductVO> selectList(Map<String, Object> map){
		return sqlSession.selectList("orderproduct.selectList",map);
	}
	
	public OrderProductVO selectOne(int idx) {
		return sqlSession.selectOne("orderproduct.selectOne",idx);
	}
	
	public int insert(OrderProductVO vo) {
		return sqlSession.insert("orderproduct.insert",vo);
	}
	
	public int delete(int idx) {
		return sqlSession.delete("orderproduct.delete",idx);
	}
	
	public int update(OrderProductVO vo) {
		return sqlSession.update("orderproduct.update",vo);
	}

}
