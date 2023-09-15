package vo.leavemember;

import java.io.File;
import java.util.Date;

public class LeaveMemberVO {
	
	private int idx;
	private int member_idx;
	private int reason_idx;
	private String wish;
	private Date leave_date;
	
	public LeaveMemberVO() {
		super();
	}
	public LeaveMemberVO(int idx, int member_idx, int reason_idx, String wish, Date leave_date) {
		super();
		this.idx = idx;
		this.member_idx = member_idx;
		this.reason_idx = reason_idx;
		this.wish = wish;
		this.leave_date = leave_date; 
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
	public int getReason_idx() {
		return reason_idx;
	}
	public void setReason_idx(int reason_idx) {
		this.reason_idx = reason_idx;
	}
	public String getWish() {
		return wish;
	}
	public void setWish(String wish) {
		this.wish = wish;
	}
	public Date getLeave_date() {
		return leave_date;
	}
	public void setLeave_date(Date leave_date) {
		this.leave_date = leave_date;
	}
	

}
