package vo.notice;

import java.util.Date;

public class NoticeVO {
	
	private int idx;
	private String title;
	private String no_content;
	private Date no_date;
	
	public NoticeVO() {
		super();
	}
	
	public NoticeVO(int idx, String title, String no_content, Date no_date) {
		super();
		this.idx = idx;
		this.title = title;
		this.no_content = no_content;
		this.no_date = no_date;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNo_Content() {
		return no_content;
	}
	public void setNo_Content(String no_content) {
		this.no_content = no_content;
	}
	public Date getNo_Date() {
		return no_date;
	}
	public void setNo_Date(Date no_date) {
		this.no_date = no_date;
	}
	
}