package vo.postcategory;

public class PostCategoryVO {
	
	private int idx;
	private int post_idx;
	private int category_idx;
	
	public PostCategoryVO() {
		super();
	}
	
	public PostCategoryVO(int idx, int post_idx, int category_idx) {
		this.idx = idx;
		this.post_idx = post_idx;
		this.category_idx = category_idx;
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
	public int getCategory_idx() {
		return category_idx;
	}
	public void setCategory_idx(int category_idx) {
		this.category_idx = category_idx;
	}

}
