package vo.options;

public class OptionsVO {
	
	private int idx;
	private int product_idx;
	private String name;
	private int price;
	private String kind;
	
	public OptionsVO() {
		super();
	}
	
	public OptionsVO(int idx, int product_idx, String name,int price,String kind) {
		super();
		
		this.idx = idx;
		this.product_idx = product_idx;
		this.name = name;
		this.price = price;
		this.kind = kind;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	


}
