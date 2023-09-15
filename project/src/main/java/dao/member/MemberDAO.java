package dao.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.member.MemberVO;

public class MemberDAO {
	
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

   
   public List<String> selectEmail() {
		return sqlSession.selectList("member.selectEmail");
	}
   
   public int checkEmail(String email) {
		int no = 0;
		
		try {
			no = sqlSession.selectOne("member.checkEmail",email);
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		
		return no;
	}
	public int checkLogin(MemberVO vo) {
		
		int no = 0;
		
		try {
			no = sqlSession.selectOne("member.checkLogin",vo);
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		
		return no;
	}
	
	public MemberVO selectOne(int idx) {
		return sqlSession.selectOne("member.selectOne", idx);
	}
	public int insert(MemberVO vo) {
		return sqlSession.insert("member.insert",vo);
	}
	
	public int delete(int idx) {
		return sqlSession.delete("member.delete", idx);
	}
	
	public int update(MemberVO vo) {
		
		System.out.println("dddddddd");
		System.out.println(vo);
		System.out.println(vo.getAgree_email());
		System.out.println(vo.getAgree_marketing());
		System.out.println(vo.getBirth_date());
		System.out.println(vo.getHomepage());
		System.out.println(vo.getIntroduce());
		System.out.println(vo.getM_picture());
		System.out.println(vo.getNickname());
		System.out.println(vo.getUserkind());
		
		int ll = sqlSession.update("member.update",vo);

		System.out.println("dddhfjhfjhfjhddddd");

		System.out.println(ll);
		
		return ll; 
	}

}
