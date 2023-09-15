package vo.comment;

public class CommentVO {
	
	private int idx;
	private int post_idx;
	private int orderNo;
	private int depth;
	
	public CommentVO() {
		super();
	}
	
	public CommentVO(int idx, int post_idx, int orderNo, int depth) {
		this.idx = idx;
		this.post_idx = post_idx;
		this.orderNo = orderNo;
		this.depth = depth;
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
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	

}
