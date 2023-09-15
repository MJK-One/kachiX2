package vo.cancel;

public class CancelVO {

	private int idx;
	private String reason;
	
	public CancelVO() {
		super();
	}
	
	public CancelVO(int idx, String reason) {
		super();
		this.idx = idx;
		this.reason = reason;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
}
