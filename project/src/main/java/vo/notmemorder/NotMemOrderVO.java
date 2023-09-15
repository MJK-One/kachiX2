package vo.notmemorder;

import java.util.Date;

public class NotMemOrderVO {

	private int idx;
	private String name;
	private String email;
	private String phone;
	private String delivery;
	
	private String send_name;
	private String send_pnum;
	
	private String address;
	private String require;
	
	private int payment_idx;
	private int option_idx;
	private int count;
	private Date order_date;
	private String order_state;
	
	public NotMemOrderVO() {
		super();
	}
	
	public NotMemOrderVO(int idx, String name, String email, String phone, String delivery, String send_name, String send_pnum,
			String address, String require, int payment_idx, int option_idx, int count, Date order_date, String order_state) {
		super();
		
		this.idx = idx;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.delivery = delivery;
		this.send_name = send_name;
		this.send_pnum = send_pnum;
		this.address = address;
		this.require = require;
		this.payment_idx = payment_idx;
		this.option_idx = option_idx;
		this.count = count;
		this.order_date = order_date;
		this.order_state = order_state;
	}
	
	public String getSend_pnum() {
		return send_pnum;
	}
	public void setSend_pnum(String send_pnum) {
		this.send_pnum = send_pnum;
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
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public String getOrder_state() {
		return order_state;
	}
	public void setOrder_state(String order_state) {
		this.order_state = order_state;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDelivery() {
		return delivery;
	}
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
	public String getSend_name() {
		return send_name;
	}
	public void setSend_name(String send_name) {
		this.send_name = send_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRequire() {
		return require;
	}
	public void setRequire(String require) {
		this.require = require;
	}
	public int getPayment_idx() {
		return payment_idx;
	}
	public void setPayment_idx(int payment_idx) {
		this.payment_idx = payment_idx;
	}

	
	
}
