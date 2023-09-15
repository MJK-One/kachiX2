package dao.brandinfo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.brandinfo.BrandInfoVO;

public class BrandInfoDAO {
	
private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public int insert(BrandInfoVO vo) {
		return sqlSession.insert("brandinfo.insert",vo);
	}
	
	public int delete(int seq) {
		return sqlSession.delete("brandinfo.delete",seq);
	}
	
	public int update(BrandInfoVO vo) {
		return sqlSession.update("brandinfo.update",vo);
	}
}
