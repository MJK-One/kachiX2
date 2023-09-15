package vo.postproduct;

public class PostProductVO {
	private int idx;
	private int post_idx;
	private int product_idx;
	
	public PostProductVO() {
		super();
	}
	
	public PostProductVO(int idx, int post_idx, int product_idx) {
		this.idx = idx;
		this.post_idx = post_idx;
		this.product_idx = product_idx;
	}

	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getPost_idx() {
		return post_idx;
	}
	public void setPost_idx(int post_idx) {
		this.post_idx = post_idx;
	}
	public int getProduct_idx() {
		return product_idx;
	}
	public void setProduct_idx(int product_idx) {
		this.product_idx = product_idx;
	}
	
	
}
