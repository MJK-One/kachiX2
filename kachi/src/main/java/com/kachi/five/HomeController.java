package com.kachi.five;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kachi.five.bean.AddressBean;
import com.kachi.five.bean.CategoryBean;
import com.kachi.five.bean.PostBean;
import com.kachi.five.bean.SearchHistoryBean;
import com.kachi.five.bean.UserBean;
import com.kachi.five.service.CategoryService;
import com.kachi.five.service.PostService;
import com.kachi.five.service.SearchService;
import com.kachi.five.service.UserService;

@Controller
@ComponentScan(basePackages = "controller.member")
@ComponentScan(basePackages = "com.kachi.five.controller")
@ComponentScan(basePackages = "controller.post")
@ComponentScan(basePackages = "controller.admin")
@ComponentScan(basePackages = "controller.search")
@ComponentScan(basePackages = "controller.buy")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private SearchService searchService;
    @Autowired 
    private PostService postService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserBean user = (UserBean) session.getAttribute("loggedInUser");

        // 로그인한 사용자만 최근 검색어를 가져옵니다.
        if (user != null) {
            try {
                List<SearchHistoryBean> recentSearches = searchService.getRecentSearchHistory(user.getUserID());
                model.addAttribute("recentSearches", recentSearches);
            } catch (Exception e) {
                System.out.println("최근 검색어를 가져오는데 실패했습니다.");
                e.printStackTrace();
            }
        }

        try {
            List<String> popularSearches = searchService.getPopularSearchKeywords();
            model.addAttribute("popularSearches", popularSearches);
        } catch (Exception e) {
            System.out.println("인기 검색어를 가져오는데 실패했습니다.");
            e.printStackTrace();
        }

        List<PostBean> posts = postService.getAllPosts();
        List<CategoryBean> categories = categoryService.getAllCategories();
        model.addAttribute("user", user); 
        model.addAttribute("categories",categories);
        model.addAttribute("posts", posts);
        return "index";
    }
	
	
	
	@RequestMapping("mainpage/storehome")
	public String storehome(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
        UserBean user = (UserBean) session.getAttribute("loggedInUser");
        
		List<PostBean> posts = postService.getAllPosts();
        List<CategoryBean> categories = categoryService.getAllCategories();
        model.addAttribute("user", user); 
        model.addAttribute("categories",categories);
        model.addAttribute("posts", posts);
		 return "mainpage/storehome";
	}
	@RequestMapping("mainpage/timesale")
	public String timesale(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
	    UserBean user = (UserBean) session.getAttribute("loggedInUser");
	    
	    List<PostBean> posts = postService.getAllPostsOrderBySalePeriod();
	    List<CategoryBean> categories = categoryService.getAllCategories();
	    model.addAttribute("user", user); 
	    model.addAttribute("categories",categories);
	    model.addAttribute("posts", posts);
			return "mainpage/timesale";
	}
	@RequestMapping("mainpage/newarticle")
	public String newarticle() {
			return "mainpage/newarticle";
	}
	@RequestMapping("mainpage/best")
	public String interest() {
			return "mainpage/best";
	}
	@RequestMapping("member/purchase")
	public String purchase(@RequestParam("postId") int postId, 
			@RequestParam("quantity") int quantity, 
            @RequestParam("totalPrice") int totalPrice, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserBean user = (UserBean) session.getAttribute("loggedInUser");
		if(user == null) return "member/loginForm"; //로그인이 안되어있으면 로그인 폼으로 이동}
		
		List<AddressBean> addresses = userService.getAddresses(user.getUserID());
	    model.addAttribute("addresses", addresses);
	    
		PostBean post = postService.getPostById(postId);
		model.addAttribute("post", post);
		model.addAttribute("totalPrice", totalPrice);
		model.addAttribute("quantity", quantity);
		model.addAttribute("user", user);
			return "member/purchase";
	}
	
	@RequestMapping("member/purchase_join")
	public String purchase_join(@RequestParam("postId") int postId, 
			@RequestParam("quantity") int quantity, 
            @RequestParam("totalPrice") int totalPrice,
            @RequestParam("groupBuyId") int groupBuyId, Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		UserBean user = (UserBean) session.getAttribute("loggedInUser");
		if(user == null) return "member/loginForm"; //로그인이 안되어있으면 로그인 폼으로 이동}
		
		List<AddressBean> addresses = userService.getAddresses(user.getUserID());
	    model.addAttribute("addresses", addresses);
	    
		PostBean post = postService.getPostById(postId);
		model.addAttribute("post", post);
		model.addAttribute("totalPrice", totalPrice);
		model.addAttribute("quantity", quantity);
		model.addAttribute("user", user);
			return "member/purchase_join";
	}

	@RequestMapping("member/searchResult")
	public String searchResult(@RequestParam("query") String query, Model model,HttpServletRequest request) {
		 HttpSession session = request.getSession();
		 UserBean user = (UserBean) session.getAttribute("loggedInUser");
		 List<PostBean> posts = postService.findPostsByTitleContaining(query);
		 List<CategoryBean> categories = categoryService.getAllCategories();
		 model.addAttribute("user", user); 
		 model.addAttribute("categories",categories);
		 model.addAttribute("posts", posts);
			return "member/searchResult";
	}
}
