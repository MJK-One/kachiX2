package dao.scrap;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;


import vo.scrap.ScrapVO;


public class ScrapDAO {

private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int scrapMCnt(int idx) {
		return sqlSession.selectOne("scrap.scrapMCnt", idx);
	}
	
	public int scrapPCnt(int idx) {
		return sqlSession.selectOne("scrap.scrapPCnt", idx);
	}
	
	public List<ScrapVO> selectList(int idx){
		return sqlSession.selectList("scrap.selectList", idx);
	}
	
	public int insert(ScrapVO vo) {
		return sqlSession.insert("scrap.insert",vo);
	}
	
	public int delete(Map<String, Object> map) {
		return sqlSession.delete("scrap.delete",map);
	}
	
	public int update(ScrapVO vo) {
		return sqlSession.update("scrap.update",vo);
	}

}
