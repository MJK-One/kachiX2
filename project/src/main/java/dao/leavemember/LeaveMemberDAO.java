package dao.leavemember;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.leavemember.LeaveMemberVO;

public class LeaveMemberDAO {

	private SqlSession sqlSession;
	
	public LeaveMemberDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<LeaveMemberVO> selectList(Map<String, Object> map){
		return sqlSession.selectList("leave_member.selectList",map);
	}
	
	public LeaveMemberVO selectOne(int seq) {
		return sqlSession.selectOne("leave_member.selectOne",seq);
	}
	public int insert(LeaveMemberVO vo) {
		return sqlSession.insert("leave_member.insert",vo);
	}
	
	public int delete(int seq) {
		return sqlSession.delete("leave_member.delete",seq);
	}
	
	public int update(LeaveMemberVO vo) {
		return sqlSession.update("leave_member.update",vo);
	}
}
