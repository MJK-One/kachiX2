package dao.brandproduct;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.brandproduct.BrandProductVO;


public class BrandProductDAO {
	
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(BrandProductVO vo) {
		return sqlSession.insert("brandproduct.insert",vo);
	}
	
	public int delete(int seq) {
		return sqlSession.delete("brandproduct.delete",seq);
	}
	
	public int update(BrandProductVO vo) {
		return sqlSession.update("brandproduct.update",vo);
	}
}
