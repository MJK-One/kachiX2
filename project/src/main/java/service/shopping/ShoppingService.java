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

public class ShoppingService {
	
	private ProductDAO productDao;
	private ProductcategoryDAO productcategoryDao;
	private OptionsDAO optionsDao;
	
	public ShoppingService(
			ProductDAO productDao,
			ProductcategoryDAO productcategoryDao,
			OptionsDAO optionsDao
			) {
		this.productDao = productDao;
		this.productcategoryDao = productcategoryDao;
		this.optionsDao = optionsDao;
	}
	
	// 상품
	
	public ProductVO product_selectOne(int idx) {
		return productDao.selectOne(idx);
	}
	
	public List<ProductVO> selectList(){
		
		List<ProductVO> list = productDao.selectList();
		
		if(list.isEmpty()) {
			list = null;
		}
		
		return list;
	}
	
	public int insert(ProductVO vo) {
		return productDao.insert(vo);
	}
	
	public int product_delete(int idx) {
		return productDao.delete(idx);
	}
	
	public int update(ProductVO vo) {
		return productDao.update(vo);
	}
	
	public int product_getIdx() {
		return productDao.getIdx();
	}
	
	// 상품 카테고리
	
	public List<ProductcategoryVO> pc_selectList(int idx){
		
		List<ProductcategoryVO> list = productcategoryDao.selectList(idx);
		
		if(list.isEmpty()) {
			list = null;
		}
		
		return list;
	}
	
	public int insert(ProductcategoryVO vo) {
		return productcategoryDao.insert(vo);
	}
	
	public int insert2(ProductcategoryVO vo) {
		return productcategoryDao.insert2(vo);
	}
	
	public int pc_delete(int idx) {
		return productcategoryDao.delete(idx);
	}
	
	public int update(ProductcategoryVO vo) {
		return productcategoryDao.update(vo);
	}
	
	// 옵션
	
	public OptionsVO opsions_selectOne(int idx) {
		return optionsDao.selectOne(idx);
	}
	
	public List<OptionsVO> selectList(Map<String, Object> map){
		
		List<OptionsVO> list = optionsDao.selectList(map);
		
		if(list.isEmpty()) {
			list = null;
		}
		
		return list;
	}
	
	public int insert(OptionsVO vo) {
		return optionsDao.insert(vo);
	}
	
	public int options_delete(int idx) {
		return optionsDao.delete(idx);
	}
	
	public int update(OptionsVO vo) {
		return optionsDao.update(vo);
	}
	

}
