package vo.product;

import org.springframework.web.multipart.MultipartFile;

public class ProductVO {
	private int idx;
	private String name;
	private String picture;
	private int brand_idx;
	private int price;
	private int sale;
	private int status;
	private int delivery;
	private String info;
	private int h;
	private String a;

	private int major_idx=0;
	private int middle_idx=0;
	private int small_idx=0;
	private String brand_name;
	
	private MultipartFile photo;
	
	public ProductVO() {
		super();
	}
	
	public ProductVO(int idx,String name, String info, String picture,int brand_idx,int price,int sale,int status,int delivery) {
		super();
		this.idx = idx;
		this.name = name;
		this.picture = picture;
		this.brand_idx = brand_idx;
		this.price = price;
		this.sale = sale;
		this.status = status;
		this.delivery = delivery;
		this.info = info;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBrand_idx() {
		return brand_idx;
	}
	public void setBrand_idx(int brand_idx) {
		this.brand_idx = brand_idx;
	}
	public int getSale() {
		return sale;
	}
	public void setSale(int sale) {
		this.sale = sale;
	}
	public int getDelivery() {
		return delivery;
	}
	public void setDelivery(int delivery) {
		this.delivery = delivery;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public MultipartFile getPhoto() {
		return photo;
	}
	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	public String getBrand_name() {
		return brand_name;
	}
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
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

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}
	
	

}
