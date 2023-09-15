package vo.order;

import java.util.Date;

public class OrderVO {

	private int idx;
	private int member_idx;
	private Date order_date;
	private int order_state;
	private int	delivery_idx;
	private int payment_idx;
	private String request;
	
	public OrderVO() {
		super();
	}
	
	public OrderVO( int idx, int member_idx, Date order_date, int order_state, int delivery_idx, int payment_idx, String request) {
		super();
		
		this.idx = idx;
		this.member_idx = member_idx;
		this.order_date = order_date;
		this.order_state = order_state;
		this.delivery_idx = delivery_idx;
		this.payment_idx = payment_idx;
		this.request = request;
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
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public int getOrder_state() {
		return order_state;
	}
	public void setOrder_state(int order_state) {
		this.order_state = order_state;
	}
	public int getPayment_idx() {
		return payment_idx;
	}
	public void setPayment_idx(int payment_idx) {
		this.payment_idx = payment_idx;
	}
	public int getDelivery_idx() {
		return delivery_idx;
	}
	public void setDelivery_idx(int delivery_idx) {
		this.delivery_idx = delivery_idx;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	
	
}
