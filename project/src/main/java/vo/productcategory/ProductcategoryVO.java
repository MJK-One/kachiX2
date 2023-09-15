package vo.productcategory;

public class ProductcategoryVO {
	
	private int idx;
	private int product_idx;
	private int major_idx;
	private int middle_idx;
	private int small_idx;
	
	public ProductcategoryVO() {
		super();
	}
	public ProductcategoryVO(int idx, int product_idx, int major_idx) {
		super();
		this.idx = idx;
		this.product_idx = product_idx;
		this.major_idx = major_idx;
	}
	
	public ProductcategoryVO(int idx, int product_idx, int major_idx, int middle_idx) {
		super();
		this.idx = idx;
		this.product_idx = product_idx;
		this.major_idx = major_idx;
		this.middle_idx = middle_idx;
	}
	
	public ProductcategoryVO(int idx, int product_idx, int major_idx, int middle_idx, int small_idx) {
		super();
		this.idx = idx;
		this.product_idx = product_idx;
		this.major_idx = major_idx;
		this.middle_idx = middle_idx;
		this.small_idx = small_idx;
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

	public int getMajor_idx() {
		return major_idx;
	}

	public void setMajor_idx(int major_idx) {
		this.major_idx = major_idx;
	}

	public int getMiddle_idx() {
		return middle_idx;
	}

	public void setMiddle_idx(int middle_idx) {
		this.middle_idx = middle_idx;
	}

	public int getSmall_idx() {
		return small_idx;
	}

	public void setSmall_idx(int small_idx) {
		this.small_idx = small_idx;
	}
	
	

}
