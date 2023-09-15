package service.member;

import java.util.List;
import java.util.Map;

import dao.brand.BrandDAO;
import dao.brandcategory.BrandCategoryDAO;
import dao.brandinfo.BrandInfoDAO;
import dao.brandproduct.BrandProductDAO;
import dao.follow.FollowDAO;
import dao.likes.LikesDAO;
import dao.majorcategory.MajorCategoryDAO;
import dao.member.MemberDAO;
import dao.scrap.ScrapDAO;
import vo.brand.BrandVO;
import vo.brandcategory.BrandCategoryVO;
import vo.brandinfo.BrandInfoVO;
import vo.brandproduct.BrandProductVO;
import vo.follow.FollowVO;
import vo.likes.LikesVO;
import vo.majorcategory.MajorCategoryVO;
import vo.member.MemberVO;
import vo.post.PostVO;
import vo.scrap.ScrapVO;

public class MemberService{
	
	private MemberDAO memberDao;
	private FollowDAO followDao;
	private LikesDAO likesDao;
	private ScrapDAO scrapDao;
	
	public MemberService(
			MemberDAO memberDao,
			FollowDAO followDao,
			LikesDAO likesDao,
			ScrapDAO scrapDao

			) {
		this.memberDao = memberDao;
		this.followDao = followDao;
		this.likesDao = likesDao;
		this.scrapDao = scrapDao;
	}
	// 멤버
	public int checkLogin(MemberVO vo) {
		return memberDao.checkLogin(vo);
	}
	
	public int checkEmail(String email) {
		return memberDao.checkEmail(email);
	}
	
	public List<String> selectEmail() {
		return memberDao.selectEmail();
	}
	
	public MemberVO selectOne(int idx) {
		return memberDao.selectOne(idx);
	}
	
	public int insert(MemberVO vo) {
		return memberDao.insert(vo);
	}
	
	public int member_delete(int idx) {
		return memberDao.delete(idx);
	}
	
	public int update(MemberVO vo) {
		System.out.println("fjhjhgjhgkjgk");
		System.out.println(vo);
		System.out.println(vo.getAgree_email());
		System.out.println(vo.getAgree_marketing());
		System.out.println(vo.getBirth_date());
		System.out.println(vo.getHomepage());
		System.out.println(vo.getIntroduce());
		System.out.println(vo.getM_picture());
		System.out.println(vo.getNickname());
		System.out.println(vo.getUserkind());
		
		int ll = memberDao.update(vo);
		
		
		return ll;
	}
	
	// 팔로우
	
	public int check(Map<String, Object> map){
		
		Integer check = followDao.check(map);
		
		return check;
	}
	
	public int followCnt(int idx) {
		return followDao.followCnt(idx);
	}
	
	public int followerCnt(int idx) {
		return followDao.followerCnt(idx);
	}
	
	public int insert(FollowVO vo) {
		return followDao.insert(vo);
	}
	
	public int follow_delete(Map<String, Object> map) {
		return followDao.delete(map);
	}
	
	// 스크랩
	
	public int scrapMCnt(int idx) {
		return scrapDao.scrapMCnt(idx);
	}
	
	public int scrapPCnt(int idx) {
		return scrapDao.scrapPCnt(idx);
	}
	
	public List<ScrapVO> scrap_selectList(int idx){
		return scrapDao.selectList(idx);
	}
	
	public int insert(ScrapVO vo) {
		return scrapDao.insert(vo);
	}
	
	public int scrap_delete(Map<String, Object> map) {
		return scrapDao.delete(map);
	}
	
	public int update(ScrapVO vo) {
		return scrapDao.update(vo);
	}
	
	// 좋아요
	
	public int likesMCnt(int idx) {
		return likesDao.likesMCnt(idx);
	}
	
	public int likesPCnt(int idx) {
		return likesDao.likesPCnt(idx);
	}
	
	public int likes_check(Map<String, Object> map){
		
		Integer check = followDao.check(map);
		
		return check;
	}
	
	public List<LikesVO> likes_selectList(int idx){
		return likesDao.selectList(idx);
	}
	
	public int insert(LikesVO vo) {
		return likesDao.insert(vo);
	}
	
	public int likes_delete(Map<String, Object> map) {
		return likesDao.delete(map);
	}
	
	public int update(LikesVO vo) {
		return likesDao.update(vo);
	}
	
	
	
}