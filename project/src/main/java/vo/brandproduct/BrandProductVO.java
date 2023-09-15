package vo.brandproduct;

public class BrandProductVO {
	
	private int idx;
	private int brand_idx;
	private String bname;
	private String introduce;
	private String othershop;
	
	public BrandProductVO() {
		super();
	}
	
	public BrandProductVO(int idx, int brand_idx, String bname, String introduce, String othershop) {
		super();
		this.idx = idx;
		this.brand_idx = brand_idx;
		this.bname = bname;
		this.introduce = introduce;
		this.othershop = othershop;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getBrand_idx() {
		return brand_idx;
	}
	public void setBrand_idx(int brand_idx) {
		this.brand_idx = brand_idx;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getOthershop() {
		return othershop;
	}

	public void setOthershop(String othershop) {
		this.othershop = othershop;
	}
	

}
