package vo.scrap;

public class ScrapVO {
	
	private int idx;
	private int member_idx;
	private int post_idx;
	private int product_idx;
	
	public ScrapVO() {
		super();
	}
	
	public ScrapVO(int idx, int member_idx, int post_idx, int product_idx) {
		this.idx = idx;
		this.member_idx = member_idx;
		this.post_idx = post_idx;
		this.product_idx = product_idx;
	}
	
	public int getProduct_idx() {
		return product_idx;
	}
	public void setProduct_idx(int product_idx) {
		this.product_idx = product_idx;
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
	public int getPost_idx() {
		return post_idx;
	}
	public void setPost_idx(int post_idx) {
		this.post_idx = post_idx;
	}
	

}
