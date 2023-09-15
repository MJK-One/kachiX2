package vo.qaanswer;

import java.util.Date;

public class QaAnswerVO {
	
	private int idx;
	private int product_qa_idx;
	private int qa_idx;
	private int member_idx;
	private Date an_time;
	private String an_brand;
	private String an_content;
	
	public QaAnswerVO() {
		super();
	}
	
	public QaAnswerVO(int idx, int product_qa_idx, int qa_idx, int member_idx, Date an_time, String an_brand, String an_content) {
		super();
		this.idx = idx;
		this.product_qa_idx = product_qa_idx;
		this.qa_idx = qa_idx;
		this.member_idx = member_idx;
		this.an_time = an_time;
		this.an_brand = an_brand;
		this.an_content = an_content;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getProduct_qa_idx() {
		return product_qa_idx;
	}
	public void setProduct_qa_idx(int product_qa_idx) {
		this.product_qa_idx = product_qa_idx;
	}
	public int getQa_idx() {
		return qa_idx;
	}
	public void setQa_idx(int qa_idx) {
		this.qa_idx = qa_idx;
	}
	public int getMember_idx() {
		return member_idx;
	}
	public void setMember_idx(int member_idx) {
		this.member_idx = member_idx;
	}
	public Date getAn_time() {
		return an_time;
	}
	public void setAn_time(Date an_time) {
		this.an_time = an_time;
	}
	public String getAn_brand() {
		return an_brand;
	}
	public void setAn_brand(String an_brand) {
		this.an_brand = an_brand;
	}
	public String getAn_content() {
		return an_content;
	}
	public void setAn_content(String an_content) {
		this.an_content = an_content;
	}

}
