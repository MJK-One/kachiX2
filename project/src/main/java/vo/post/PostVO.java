package vo.post;

import java.sql.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import vo.likes.LikesVO;
import vo.scrap.ScrapVO;

public class PostVO {
	
	private int idx;
	private int member_idx;
	private Date time;
	private String picture;
	private String explanation;
	private String title;
	private String content;
	private String kind;
	private int hit;
	
	//member
	private String nickname;
	private String m_picture;
	private String introduce;
	
	private List<ScrapVO> svo;
	private int check;
	
	private List<LikesVO> lvo;
	private int lcheck;
	
	private int likesPCnt;
	private int scrapPCnt;

	private int likesMCnt;
	private int scrapMCnt;
	
	private MultipartFile photo;
	
	public PostVO() {
		super();
	}
	
	public PostVO(int idx, int member_idx, Date time, String picture, String explanation, String title, String content, String kind, int hit) {
		this.idx = idx;
		this.member_idx = member_idx;
		this.time = time;
		this.picture = picture;
		this.explanation = explanation;
		this.title = title;
		this.content = content;
		this.kind = kind;
		this.hit = hit;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getMember_idx() {
		return member_idx;
	}
	public void setMember_idx(int member_idx) {
		this.member_idx = member_idx;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getM_picture() {
		return m_picture;
	}

	public void setM_picture(String m_picture) {
		this.m_picture = m_picture;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public List<ScrapVO> getSvo() {
		return svo;
	}

	public void setSvo(List<ScrapVO> svo) {
		this.svo = svo;
	}

	public int getCheck() {
		return check;
	}

	public void setCheck(int check) {
		this.check = check;
	}

	public List<LikesVO> getLvo() {
		return lvo;
	}

	public void setLvo(List<LikesVO> lvo) {
		this.lvo = lvo;
	}

	public int getLcheck() {
		return lcheck;
	}

	public void setLcheck(int lcheck) {
		this.lcheck = lcheck;
	}

	public int getLikesPCnt() {
		return likesPCnt;
	}

	public void setLikesPCnt(int likesPCnt) {
		this.likesPCnt = likesPCnt;
	}

	public int getScrapPCnt() {
		return scrapPCnt;
	}

	public void setScrapPCnt(int scrapPCnt) {
		this.scrapPCnt = scrapPCnt;
	}

	public int getLikesMCnt() {
		return likesMCnt;
	}

	public void setLikesMCnt(int likesMCnt) {
		this.likesMCnt = likesMCnt;
	}

	public int getScrapMCnt() {
		return scrapMCnt;
	}

	public void setScrapMCnt(int scrapMCnt) {
		this.scrapMCnt = scrapMCnt;
	}

}
