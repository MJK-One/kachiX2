package dao.payment;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.payment.PaymentVO;

public class PaymentDAO {

	private SqlSession sqlSession;
	
	public PaymentDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<PaymentVO> selectList(Map<String, Object> map){
		return sqlSession.selectList("payment.selectList",map);
	}
	
	public PaymentVO selectOne(int idx) {
		return sqlSession.selectOne("payment.selectOne",idx);
	}
	
	public int insert(PaymentVO vo) {
		return sqlSession.insert("payment.insert",vo);
	}
	
	public int delete(int idx) {
		return sqlSession.delete("payment.delete",idx);
	}
	
	public int update(PaymentVO vo) {
		return sqlSession.update("payment.update",vo);
	}
	
}
