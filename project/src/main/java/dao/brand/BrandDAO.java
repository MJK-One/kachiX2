package dao.brand;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.brand.BrandVO;

public class BrandDAO {
	
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<BrandVO> selectList(){
		return sqlSession.selectList("brand.selectList");
	}
	
	public String selectName(int idx) {
		return sqlSession.selectOne("brand.selectName",idx);
	}
	
	public BrandVO selectOne(int idx) {
		return sqlSession.selectOne("brand.selectOne",idx);
	}
	
	public int insert(BrandVO vo) {
		return sqlSession.insert("brand.insert",vo);
	}
	
	public int delete(int seq) {
		return sqlSession.delete("brand.delete",seq);
	}
	
	public int update(BrandVO vo) {
		return sqlSession.update("brand.update",vo);
	}
	
	public int getIdx() {
		return sqlSession.selectOne("brand.getIdx");
	}

}
