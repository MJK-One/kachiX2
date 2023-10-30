package controller.search;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kachi.five.bean.SearchHistoryBean;
import com.kachi.five.bean.SearchKeyword;
import com.kachi.five.service.SearchService;

@Controller
public class SearchController {
	@Autowired
    private SearchService searchService;

	
	/*
	 * //최근 검색어
	 * 
	 * @GetMapping("/search/history") public String getSearchHistory(@RequestParam
	 * String userId, Model model) { List<SearchHistoryBean> recentSearches =
	 * searchService.getRecentSearchHistory(userId);
	 * model.addAttribute("recentSearches", recentSearches); return "member/search";
	 * } //인기 검색어
	 * 
	 * @GetMapping("/search/popular") public String getPopularKeywords(Model model)
	 * { List<String> popularSearches = searchService.getPopularSearchKeywords();
	 * model.addAttribute("popularSearches", popularSearches); return
	 * "member/search"; }
	 */
		
	  // 사용자가 검색을 실행할 때마다 검색어를 최근 검색어에 추가하고, 그 검색어의 검색 횟수를 늘리는 메소드
		@PostMapping("/search/record")
		public ResponseEntity<Void> recordSearch(@RequestParam String userId, @RequestParam String keyword) {
		    // 로그인된 사용자인지 체크
		    if (userId == null || userId.trim().isEmpty()) {
		        // 사용자 ID가 없는 경우, 401 Unauthorized 상태 코드 반환
		        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		    }
		    
		    // 로그인된 사용자의 경우, 검색어 기록 진행
		    searchService.recordSearch(userId, keyword);
		    return new ResponseEntity<>(HttpStatus.OK);
		}
	    
	    //최근 검색어 삭제
		@PostMapping("/search/history/delete")
		public ResponseEntity<Void> deleteSelected(@RequestBody List<String> searchId) {
		    searchService.deleteSearchHistoryById(searchId);
		    return new ResponseEntity<>(HttpStatus.OK);
		}
		
	    //최근 검색어 전체 삭제
	    @PostMapping("/search/history/delete/all")
	    public ResponseEntity<Void> deleteAll(@RequestParam String userId) {
	        searchService.deleteAllSearchHistory(userId);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
	    
	    
	    
	    
}
