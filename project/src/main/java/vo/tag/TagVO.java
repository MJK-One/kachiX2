package vo.tag;

public class TagVO {
	
	private int idx;
	private String tag;
	private int post_idx;
	
	public TagVO() {
		super();
	}
	
	public TagVO(int idx, String tag, int post_idx) {
		this.idx = idx;
		this.tag = tag;
		this.post_idx = post_idx;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public int getPost_idx() {
		return post_idx;
	}
	public void setPost_idx(int post_idx) {
		this.post_idx = post_idx;
	}
	
	


}
