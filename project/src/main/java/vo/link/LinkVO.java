package vo.link;

public class LinkVO {
	
	private int idx;
	private int post_idx;
	private String link;
	
	public LinkVO() {
		super();
	}
	
	public LinkVO(int idx, int post_idx, String link) {
		this.idx = idx;
		this.post_idx = post_idx;
		this.link = link;
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
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	

}
