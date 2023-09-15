package vo.fqa;

public class FqaVO {
	
	private int idx;
	private String question;
	private String answer;
	private int fqa_category_idx;
	
	public FqaVO() {
		super();
	}
	
	public FqaVO(int idx, String question, String answer, int fqa_category_idx) {
		super();
		this.idx = idx;
		this.question = question;
		this.answer = answer;
		this.fqa_category_idx = fqa_category_idx;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getFqa_category_idx() {
		return fqa_category_idx;
	}
	public void setFqa_category_idx(int fqa_category_idx) {
		this.fqa_category_idx = fqa_category_idx;
	}
	
	
}