package service.shopping;

import java.util.List;
import java.util.Map;

import dao.majorcategory.MajorCategoryDAO;
import dao.middlecategory.MiddleCategoryDAO;
import dao.options.OptionsDAO;
import dao.product.ProductDAO;
import dao.productcategory.ProductcategoryDAO;
import dao.smallcategory.SmallCategoryDAO;
import vo.majorcategory.MajorCategoryVO;
import vo.middlecategory.MiddleCategoryVO;
import vo.options.OptionsVO;
import vo.product.ProductVO;
import vo.productcategory.ProductcategoryVO;
import vo.smallcategory.SmallCategoryVO;

public class CategoryService {
	private MajorCategoryDAO majorcategoryDao;
	private MiddleCategoryDAO middlecategoryDao;
	private SmallCategoryDAO smallcategoryDao;

	
	public CategoryService(
			MajorCategoryDAO majorcategoryDao,
			MiddleCategoryDAO middlecategoryDao,
			SmallCategoryDAO smallcategoryDao
			) {

		this.majorcategoryDao = majorcategoryDao;
		this.middlecategoryDao = middlecategoryDao;
		this.smallcategoryDao = smallcategoryDao;
	}
	
	// 대분류 카테고리
	
	public List<MajorCategoryVO> selectName(String kind){
		return majorcategoryDao.selectName(kind);
	}
	
	public MajorCategoryVO selectOne(int idx) {
		return majorcategoryDao.selectOne(idx);
	}
	
	public int insert(MajorCategoryVO vo) {
		return majorcategoryDao.insert(vo);
	}
	
	
	public int delete(int idx) {
		return majorcategoryDao.delete(idx);
	}
	
	public int update(MajorCategoryVO vo) {
		return majorcategoryDao.update(vo);
	}
	
	// 중분류 카테고리
	
	public List<MiddleCategoryVO> mi_selectName(int idx){
		return middlecategoryDao.selectName(idx);
	}
	
	public int insert(MiddleCategoryVO vo) {
		return middlecategoryDao.insert(vo);
	}
	
	
	public int middle_delete(int idx) {
		return middlecategoryDao.delete(idx);
	}
	
	public int update(MiddleCategoryVO vo) {
		return middlecategoryDao.update(vo);
	}
	
	// 소분류 카테고리
	
	public List<SmallCategoryVO> sm_selectName(int idx){
		return smallcategoryDao.selectName(idx);
	}
	
	public int insert(SmallCategoryVO vo) {
		return smallcategoryDao.insert(vo);
	}
	
	
	public int small_delete(int idx) {
		return smallcategoryDao.delete(idx);
	}
	
	public int update(SmallCategoryVO vo) {
		return smallcategoryDao.update(vo);
	}
	
}
