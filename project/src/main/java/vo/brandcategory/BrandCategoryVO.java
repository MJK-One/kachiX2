package vo.brandcategory;

public class BrandCategoryVO {
	
	private int idx;
	private int brand_product_idx;
	private int categories_idx;
	
	public BrandCategoryVO() {
		super();
	}
	public BrandCategoryVO(int idx, int brand_product_idx, int categories_idx) {
		super();
		this.idx = idx;
		this.brand_product_idx = brand_product_idx;
		this.categories_idx = categories_idx;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getBrand_product_idx() {
		return brand_product_idx;
	}
	public void setBrand_product_idx(int brand_product_idx) {
		this.brand_product_idx = brand_product_idx;
	}
	public int getCategories_idx() {
		return categories_idx;
	}
	public void setCategories_idx(int categories_idx) {
		this.categories_idx = categories_idx;
	}
	
	
	

}
