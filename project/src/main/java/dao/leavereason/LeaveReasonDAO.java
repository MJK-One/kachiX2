package dao.leavereason;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.leavereason.LeaveReasonVO;

public class LeaveReasonDAO {

private SqlSession sqlSession;
	
	public LeaveReasonDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<LeaveReasonVO> selectList(Map<String, Object> map){
		return sqlSession.selectList("leave_reason.selectList",map);
	}
	
	public LeaveReasonVO selectOne(int seq) {
		return sqlSession.selectOne("leave_reason.selectOne",seq);
	}
	public int insert(LeaveReasonVO vo) {
		return sqlSession.insert("leave_reason.insert",vo);
	}
	
	public int delete(int seq) {
		return sqlSession.delete("leave_reason.delete",seq);
	}
	
	public int update(LeaveReasonVO vo) {
		return sqlSession.update("leave_reason.update",vo);
	}

}
