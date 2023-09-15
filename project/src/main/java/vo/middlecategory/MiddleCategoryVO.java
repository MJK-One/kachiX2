package vo.middlecategory;

import java.util.List;

import vo.smallcategory.SmallCategoryVO;

public class MiddleCategoryVO {
	
	private int idx;
	private int major_idx;
	private String name;
	private List<SmallCategoryVO> smvo;
	
	public MiddleCategoryVO() {
		super();
	}
	
	public MiddleCategoryVO(int idx, int major_idx, String name) {
		this.idx = idx;
		this.major_idx = major_idx;
		this.name = name;
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
	public int getMajor_idx() {
		return major_idx;
	}
	public void setMajor_idx(int major_idx) {
		this.major_idx = major_idx;
	}

	public List<SmallCategoryVO> getSmvo() {
		return smvo;
	}

	public void setSmvo(List<SmallCategoryVO> smvo) {
		this.smvo = smvo;
	}


}
