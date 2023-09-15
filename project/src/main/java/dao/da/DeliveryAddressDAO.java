package dao.da;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.da.DeliveryAddressVO;

public class DeliveryAddressDAO {

	private SqlSession sqlSession;
	
	public DeliveryAddressDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<DeliveryAddressVO> selectList(Map<String, Object> map){
		return sqlSession.selectList("da.selectList",map);
	}
	
	public DeliveryAddressVO selectOne(int idx) {
		return sqlSession.selectOne("da.selectOne",idx);
	}
	
	public int insert(DeliveryAddressVO vo) {
		return sqlSession.insert("da.insert",vo);
	}
	
	public int delete(int idx) {
		return sqlSession.delete("da.delete",idx);
	}
	
	public int update(DeliveryAddressVO vo) {
		return sqlSession.update("da.update",vo);
	}
	
}
