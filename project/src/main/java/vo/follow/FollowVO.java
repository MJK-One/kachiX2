package vo.follow;

public class FollowVO {
	
	private int idx;
	private int member_idx;
	private int follow_idx;
	
	public FollowVO() {
		super();
	}
	public FollowVO(int idx, int member_idx, int follow_idx) {
		super();
		this.idx = idx;
		this.member_idx = member_idx;
		this.follow_idx = follow_idx;
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
	public int getFollow_idx() {
		return follow_idx;
	}
	public void setFollow_idx(int follow_idx) {
		this.follow_idx = follow_idx;
	}
	
	

}
