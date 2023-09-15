package vo.brandinfo;

public class BrandInfoVO {
	
	private int idx;
	private int member_idx;
	private int brand_idx;
	private String name;
	private String pnum;
	private String email;
	private int private_agree;
	
	public BrandInfoVO() {
		super();
	}
	
	public BrandInfoVO(int idx, int member_idx, int brand_idx, String name, String pnum, String email, int private_agree) {
		super();
		this.idx = idx;
		this.member_idx = member_idx;
		this.brand_idx = brand_idx;
		this.name = name;
		this.pnum = pnum;
		this.email = email;
		this.private_agree = private_agree; 
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
	public int getBrand_idx() {
		return brand_idx;
	}
	public void setBrand_idx(int brand_idx) {
		this.brand_idx = brand_idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPnum() {
		return pnum;
	}
	public void setPnum(String pnum) {
		this.pnum = pnum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPrivate_agree() {
		return private_agree;
	}
	public void setPrivate_agree(int private_agree) {
		this.private_agree = private_agree;
	}
	

}
