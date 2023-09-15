package service.member;

import java.util.List;
import java.util.Map;

import dao.brand.BrandDAO;
import dao.brandcategory.BrandCategoryDAO;
import dao.brandinfo.BrandInfoDAO;
import dao.brandproduct.BrandProductDAO;
import vo.brand.BrandVO;
import vo.brandcategory.BrandCategoryVO;
import vo.brandinfo.BrandInfoVO;
import vo.brandproduct.BrandProductVO;

public class BrandService {
	
	private BrandDAO brandDao;
	private BrandInfoDAO brandinfoDao;
	private BrandProductDAO brandproductDao;
	private BrandCategoryDAO brandcategoryDao;
	
	public BrandService(
			BrandDAO brandDao,
			BrandInfoDAO brandinfoDao,
			BrandProductDAO brandproductDao,
			BrandCategoryDAO brandcategoryDao
			) {
		this.brandDao = brandDao;
		this.brandinfoDao = brandinfoDao;
		this.brandproductDao = brandproductDao;
		this.brandcategoryDao = brandcategoryDao;
	}
	
	// 브랜드
		public List<BrandVO> brand_selectList(){
			return brandDao.selectList();
		}
		
		public String brand_selectName(int idx) {
			return brandDao.selectName(idx);
		}
		
		public BrandVO brand_selectOne(int idx) {
			return brandDao.selectOne(idx);
		}
		
		public int insert(BrandVO vo) {
			return brandDao.insert(vo);
		}
		
		public int brand_delete(int idx) {
			return brandDao.delete(idx);
		}
		
		public int update(BrandVO vo) {
			return brandDao.update(vo);
		}
		
		public int getIdx() {
			return brandDao.getIdx();
		}
		
		// 브랜드 정보
		
		public int insert(BrandInfoVO vo) {
			return brandinfoDao.insert(vo);
		}
		
		public int brandinfo_delete(int idx) {
			return brandinfoDao.delete(idx);
		}
		
		public int update(BrandInfoVO vo) {
			return brandinfoDao.update(vo);
		}
		
		// 브랜드 상품 정보
		
		public int insert(BrandProductVO vo) {
			return brandproductDao.insert(vo);
		}
		
		public int brandproduct_delete(int idx) {
			return brandproductDao.delete(idx);
		}
		
		public int update(BrandProductVO vo) {
			return brandproductDao.update(vo);
		}
		
		// 브랜드 카테고리
		
		public List<BrandCategoryVO> brandcategory_selectList(Map<String, Object> map){
			
			List<BrandCategoryVO> list = brandcategoryDao.selectList(map);
			
			if(list.isEmpty()) {
				list = null;
			}
			
			return list;
		}
		
		public BrandCategoryVO brandcategory_selectOne(int idx) {
			return brandcategoryDao.selectOne(idx);
		}
		
		public int insert(BrandCategoryVO vo) {
			return brandcategoryDao.insert(vo);
		}
		
		public int brandcategory_delete(int idx) {
			return brandcategoryDao.delete(idx);
		}
		
		public int update(BrandCategoryVO vo) {
			return brandcategoryDao.update(vo);
		}
		

}
