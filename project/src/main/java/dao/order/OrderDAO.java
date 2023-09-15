package dao.order;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.order.OrderVO;

public class OrderDAO {

	private SqlSession sqlSession;
	
	public OrderDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<OrderVO> selectList(Map<String, Object> map){
		return sqlSession.selectList("order.selectList",map);
	}
	
	public OrderVO selectOne(int idx) {
		return sqlSession.selectOne("order.selectOne",idx);
	}
	
	public int insert(OrderVO vo) {
		return sqlSession.insert("order.insert",vo);
	}
	
	public int delete(int idx) {
		return sqlSession.delete("order.delete",idx);
	}
	
	public int update(OrderVO vo) {
		return sqlSession.update("order.update",vo);
	}
}
