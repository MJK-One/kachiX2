package vo.leavereason;

import java.util.Date;

public class LeaveReasonVO {
	
	private int idx;
	private String reason_content;
	
	public LeaveReasonVO() {
		super();
	}
	public LeaveReasonVO(int idx, String reason_content) {
		super();
		this.idx = idx;
		this.reason_content = reason_content;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getReason_content() {
		return reason_content;
	}
	public void setReason_content(String reason_content) {
		this.reason_content = reason_content;
	}
	
	

}
