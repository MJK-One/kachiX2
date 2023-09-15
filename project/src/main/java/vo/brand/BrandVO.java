package vo.brand;

public class BrandVO {
	
	private int idx;
	private String brand_name;
	private String homepage;
	private String serial_num;
	
	public BrandVO() {
		super();
	}
	public BrandVO(int idx, String brand_name, String homepage, String serial_num) {
		super();
		this.idx = idx;
		this.brand_name = brand_name;
		this.homepage = homepage;
		this.serial_num = serial_num;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getBrand_name() {
		return brand_name;
	}
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	public String getSerial_num() {
		return serial_num;
	}
	public void setSerial_num(String serial_num) {
		this.serial_num = serial_num;
	}
	

}
