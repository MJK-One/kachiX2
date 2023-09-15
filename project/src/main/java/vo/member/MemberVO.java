package vo.member;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class MemberVO {

	private int idx;
	private String userpw;
	private int userkind;
	private String email;
	private String nickname;
	private String homepage;
	private String birth_date;
	private String introduce;
	private int gender;
	private Date joindate;
	private int agree_marketing;
	private int agree_email;
	private String m_picture;
	
	private MultipartFile photo;
	
	private int followCnt;
	private int followerCnt;
	
	public MemberVO() {
		super();
	}
	
	public MemberVO(int idx, String userpw, int userkind, String email, String nickname, String homepage, String birth_date, String introduce, int gender, Date joindate, int agree_marketing, int agree_email) {
		super();
		this.idx = idx;
		this.userpw = userpw;
		this.email = email;
		this.nickname = nickname;
		this.homepage = homepage;
		this.birth_date = birth_date;
		this.introduce = introduce;
		this.gender = gender;
		this.joindate = joindate;
		this.agree_marketing = agree_marketing;
		this.agree_email = agree_email;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public int getUserkind() {
		return userkind;
	}
	public void setUserkind(int userkind) {
		this.userkind = userkind;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	public String getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public Date getJoindate() {
		return joindate;
	}
	public void setJoinDate(Date joinDate) {
		this.joindate = joinDate;
	}
	public int getAgree_marketing() {
		return agree_marketing;
	}
	public void setAgree_marketing(int agree_marketing) {
		this.agree_marketing = agree_marketing;
	}
	public int getAgree_email() {
		return agree_email;
	}
	public void setAgree_email(int agree_email) {
		this.agree_email = agree_email;
	}

	public int getFollowCnt() {
		return followCnt;
	}

	public void setFollowCnt(int followCnt) {
		this.followCnt = followCnt;
	}

	public int getFollowerCnt() {
		return followerCnt;
	}

	public void setFollowerCnt(int followerCnt) {
		this.followerCnt = followerCnt;
	}

	public String getM_picture() {
		return m_picture;
	}

	public void setM_picture(String m_picture) {
		this.m_picture = m_picture;
	}

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}
	
	
}
