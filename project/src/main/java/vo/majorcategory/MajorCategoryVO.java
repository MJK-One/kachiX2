package vo.majorcategory;

import java.util.List;

import vo.middlecategory.MiddleCategoryVO;

public class MajorCategoryVO {
	
	private int idx;
	private String name;
	private String kind;
	private List<MiddleCategoryVO> mivo;
	
	public MajorCategoryVO() {
		super();
	}
	
	public MajorCategoryVO(int idx, String name, String kind) {
		this.idx = idx;
		this.name = name;
		this.kind = kind;
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
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}

	public List<MiddleCategoryVO> getMivo() {
		return mivo;
	}

	public void setMivo(List<MiddleCategoryVO> mivo) {
		this.mivo = mivo;
	}


	

}
