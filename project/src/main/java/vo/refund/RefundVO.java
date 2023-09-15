package vo.refund;

public class RefundVO {
	
	private int idx;
	private int refund_cost;
	private int exchange_cost;
	private String place;
	private int cancel_idx;
	private int status;
	
	public RefundVO() {
		super();
	}
	
	public RefundVO( int idx,int refund_cost,int exchange_cost,String place,int cancel_idx,int status) {
		super();
		
		this.idx = idx;
		this.refund_cost = refund_cost;
		this.exchange_cost = exchange_cost;
		this.place = place;
		this.cancel_idx = cancel_idx;
		this.status = status;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getRefund_cost() {
		return refund_cost;
	}
	public void setRefund_cost(int refund_cost) {
		this.refund_cost = refund_cost;
	}
	public int getExchange_cost() {
		return exchange_cost;
	}
	public void setExchange_cost(int exchange_cost) {
		this.exchange_cost = exchange_cost;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public int getCancel_idx() {
		return cancel_idx;
	}
	public void setCancel_idx(int cancel_idx) {
		this.cancel_idx = cancel_idx;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
