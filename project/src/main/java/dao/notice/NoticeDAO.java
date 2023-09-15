package dao.notice;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.notice.NoticeVO;

public class NoticeDAO {

	private SqlSession sqlSession;
	
	public NoticeDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<NoticeVO> selectList(Map<String, Object> map){
		return sqlSession.selectList("notice.selectList",map);
	}
	
	public NoticeVO selectOne(int seq) {
		return sqlSession.selectOne("notice.selectOne",seq);
	}
	public int insert(NoticeVO vo) {
		return sqlSession.insert("notice.insert",vo);
	}
	
	public int delete(int seq) {
		return sqlSession.delete("notice.delete",seq);
	}
	
	public int update(NoticeVO vo) {
		return sqlSession.update("notice.update",vo);
	}

}
