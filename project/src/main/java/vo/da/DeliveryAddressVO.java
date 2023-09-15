package vo.da;

public class DeliveryAddressVO {
	
	private int idx;
	private int member_idx;
	private String address_name;
	private String name;
	private String phone;
	private String address;
	private String request;
	
	public DeliveryAddressVO() {
		super();
	}
	
	public DeliveryAddressVO( int idx, int member_idx, String address_name, String name, String phone, String address, String request) {
		super();
		this.idx = idx;
		this.member_idx = member_idx;
		this.address_name = address_name;
		this.name = name;
		this.phone = phone;
		this.address = address;
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
	public String getAddress_name() {
		return address_name;
	}
	public void setAddress_name(String address_name) {
		this.address_name = address_name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	
}
