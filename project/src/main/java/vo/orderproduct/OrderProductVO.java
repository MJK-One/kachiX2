package vo.orderproduct;

public class OrderProductVO {

	private int idx;
	private int order_idx;
	private int product_idx;
	private int option_idx;
	private int count;
	
	public OrderProductVO() {
		super();
	}
	
	public OrderProductVO( int idx, int order_idx, int product_idx, int option_idx, int count) {
		super();
		
		this.idx = idx;
		this.order_idx = order_idx;
		this.product_idx = product_idx;
		this.option_idx = option_idx;
		this.count = count;
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
	public int getProduct_idx() {
		return product_idx;
	}
	public void setProduct_idx(int product_idx) {
		this.product_idx = product_idx;
	}
	public int getOption_idx() {
		return option_idx;
	}
	public void setOption_idx(int option_idx) {
		this.option_idx = option_idx;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
