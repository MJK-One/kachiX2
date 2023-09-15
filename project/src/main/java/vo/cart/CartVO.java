package vo.cart;

public class CartVO {
	
	private int idx;
	private int product_idx;
	private int brand_idx;
	private int option_idx;
	private int count;
	private int product_cost;
	private int delivery_cost;
	private int product_sale;
	
	public CartVO() {
		super();
	}
	
	public CartVO(int idx, int product_idx, int brand_idx, int option_idx, int count, 
			int product_cost,int delivery_cost, int product_sale) {
		super();
		this.idx = idx;
		this.product_idx = product_idx;
		this.brand_idx = brand_idx;
		this.option_idx = option_idx;
		this.count = count;
		this.product_cost = product_cost;
		this.delivery_cost = delivery_cost;
		this.product_sale = product_sale;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getProduct_idx() {
		return product_idx;
	}
	public void setProduct_idx(int product_idx) {
		this.product_idx = product_idx;
	}
	public int getBrand_idx() {
		return brand_idx;
	}
	public void setBrand_idx(int brand_idx) {
		this.brand_idx = brand_idx;
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
	public int getProduct_cost() {
		return product_cost;
	}
	public void setProduct_cost(int product_cost) {
		this.product_cost = product_cost;
	}
	public int getDelivery_cost() {
		return delivery_cost;
	}
	public void setDelivery_cost(int delivery_cost) {
		this.delivery_cost = delivery_cost;
	}
	public int getProduct_sale() {
		return product_sale;
	}
	public void setProduct_sale(int product_sale) {
		this.product_sale = product_sale;
	}
	
	
}
