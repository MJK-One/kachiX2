package vo.review;

import java.util.Date;

public class ReviewVO {
	
	private int idx;
	private int product_idx;
	private int member_idx;
	private Date buy_date;
	private int score;
	private int intense;
	private int price;
	private int design;
	private int delivery;
	private int option_idx;
	private String content;
	private int help;
	
	public ReviewVO() {
		super();
	}
	
	public ReviewVO(int idx,int product_idx,int member_idx, Date buy_date,int score,int intense,int price,int design,
			int delivery,int option_idx,String content,int help) {
		super();
		
		this.idx = idx;
		this.product_idx = product_idx;
		this.member_idx = member_idx;
		this.buy_date = buy_date;
		this.score = score;
		this.intense = intense;
		this.price = price;
		this.design = design;
		this.delivery = delivery;
		this.option_idx = option_idx;
		this.content = content;
		this.help = help;

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
	public int getMember_idx() {
		return member_idx;
	}
	public void setMember_idx(int member_idx) {
		this.member_idx = member_idx;
	}
	public Date getBuy_date() {
		return buy_date;
	}
	public void setBuy_date(Date buy_date) {
		this.buy_date = buy_date;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getIntense() {
		return intense;
	}
	public void setIntense(int intense) {
		this.intense = intense;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDesign() {
		return design;
	}
	public void setDesign(int design) {
		this.design = design;
	}
	public int getDelivery() {
		return delivery;
	}
	public void setDelivery(int delivery) {
		this.delivery = delivery;
	}
	public int getOption_idx() {
		return option_idx;
	}
	public void setOption_idx(int option_idx) {
		this.option_idx = option_idx;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHelp() {
		return help;
	}
	public void setHelp(int help) {
		this.help = help;
	}
	

}
