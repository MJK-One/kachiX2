package vo.productqa;

import java.io.File;
import java.util.Date;

public class ProductQaVO {
	
	private int idx;
	private int member_idx;
	private int qa_kind_idx;
	private String content;
	private int status;
	private int product_idx;
	private Date time;
	
	public ProductQaVO() {
		super();
	}
	public ProductQaVO(int idx,  int member_idx, int qa_kind_idx, String content, int status, int product_idx, Date time) {
		super();
		this.idx = idx;
		this.member_idx = member_idx;
		this.qa_kind_idx = qa_kind_idx;
		this.content = content;
		this.status = status;
		this.product_idx = product_idx;
		this.time = time;
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
	public int getQa_kind_idx() {
		return qa_kind_idx;
	}
	public void setQa_kind_idx(int qa_kind_idx) {
		this.qa_kind_idx = qa_kind_idx;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getProduct_idx() {
		return product_idx;
	}
	public void setProduct_idx(int product_idx) {
		this.product_idx = product_idx;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	

}
