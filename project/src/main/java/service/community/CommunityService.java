package service.community;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import dao.post.PostDAO;
import vo.post.PostVO;

public class CommunityService {
	
	private PostDAO postDao;
	
	public CommunityService(
			PostDAO postDao
			) {
		this.postDao = postDao;
	}
	
	// 게시물
	
	public int selectCntP(int idx) {
		return postDao.selectCntP(idx);
	}
	
	public int selectCntH(int idx) {
		return postDao.selectCntH(idx);
	}
	
	public PostVO selectOne(int idx) {
		return postDao.selectOne(idx);
	}
	
	public List<PostVO> post_selectList(String kind){
		List<PostVO> list = postDao.selectList(kind);
		
		if(list.isEmpty()) {
			list = null;
	    } 
		return list;
	}
	
	public List<PostVO> selectMy(int idx){
		List<PostVO> list = postDao.selectMy(idx);
		
		if(list.isEmpty()) {
			list = null;
		} 
		return list;
	}
	
	public Map<String, Object> getContent(int idx){
		postDao.readCount(idx);
		
		Map<String, Object> map = postDao.getContent(idx);
		
		String str = "";
		
		StringBuffer buf = new StringBuffer();
		
		Clob clob = (Clob)map.get("CONTENT");
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(clob.getCharacterStream());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		try {
			while((str = br.readLine()) != null) {
				buf.append(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		map.put("CONTENT", buf.toString());
		
		return map;
	}
	
	public int insert(PostVO vo) {
		return postDao.insert(vo);
	}
	
	public int delete(int idx) {
		return postDao.delete(idx);
	}
	
	public int update(PostVO vo) {
		return postDao.update(vo);
	}
	
	public int getIdx() {
		return postDao.getIdx();
	}

}
