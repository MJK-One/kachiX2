package vo.payment;

public class PaymentVO {

	private int idx;
	private int order_idx;
	private int total;
	private int delivery_charge;
	private int point;
	private String product_coupon;
	private String cart_coupon;
	private int payment_amount;
	private String payment_method;
	
	public PaymentVO() {
		super();
	}
	
	public PaymentVO( int idx,int order_idx,int total,int delivery_charge,
			int point,String product_coupon,String cart_coupon,int payment_amount,String payment_method) {
		super();
				
		this.idx = idx;
		this.order_idx = order_idx;
		this.total = total;
		this.delivery_charge = delivery_charge;
		this.point = point;
		this.product_coupon = product_coupon;
		this.cart_coupon = cart_coupon;
		this.payment_amount = payment_amount;
		this.payment_method = payment_method;	
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getOrder_idx() {
		return order_idx;
	}
	public void setOrder_idx(int order_idx) {
		this.order_idx = order_idx;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getDelivery_charge() {
		return delivery_charge;
	}
	public void setDelivery_charge(int delivery_charge) {
		this.delivery_charge = delivery_charge;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getProduct_coupon() {
		return product_coupon;
	}
	public void setProduct_coupon(String product_coupon) {
		this.product_coupon = product_coupon;
	}
	public String getCart_coupon() {
		return cart_coupon;
	}
	public void setCart_coupon(String cart_coupon) {
		this.cart_coupon = cart_coupon;
	}
	public int getPayment_amount() {
		return payment_amount;
	}
	public void setPayment_amount(int payment_amount) {
		this.payment_amount = payment_amount;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}
	
	
}
