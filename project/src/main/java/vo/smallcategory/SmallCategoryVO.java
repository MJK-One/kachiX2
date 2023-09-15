package vo.smallcategory;

public class SmallCategoryVO {
	private int idx;
	private int middle_idx;
	private String name;
	
	public SmallCategoryVO() {
		super();
	}
	
	public SmallCategoryVO(int idx, int middle_idx, String name) {
		this.idx = idx;
		this.middle_idx = middle_idx;
		this.name = name;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	
	public int getMiddle_idx() {
		return middle_idx;
	}

	public void setMiddle_idx(int middle_idx) {
		this.middle_idx = middle_idx;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	

}
