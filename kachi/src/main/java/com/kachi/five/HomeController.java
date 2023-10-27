package com.kachi.five;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kachi.five.bean.CategoryBean;
import com.kachi.five.bean.PostBean;
import com.kachi.five.service.CategoryService;
import com.kachi.five.service.PostService;

@Controller
@ComponentScan(basePackages = "controller.member")
@ComponentScan(basePackages = "com.kachi.five.controller")
@ComponentScan(basePackages = "controller.post")
@ComponentScan(basePackages = "controller.admin")

public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);


    @Autowired 
    private PostService postService;
    @Autowired
    private CategoryService categoryService;
    
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		 List<PostBean> posts = postService.getAllPosts();
		 List<CategoryBean> categories = categoryService.getAllCategories();
		 model.addAttribute("categories",categories);
		 model.addAttribute("posts", posts);
		return "index";
	}
	
	
	@RequestMapping("member/search")
	public String search() {
			return "member/search";
	}
	
	@RequestMapping("mainpage/storehome")
	public String storehome() {
		
		 return "redirect:/";
	}
	@RequestMapping("mainpage/timesale")
	public String timesale() {
			return "mainpage/timesale";
	}
	@RequestMapping("mainpage/newarticle")
	public String newarticle() {
			return "mainpage/newarticle";
	}
	@RequestMapping("mainpage/interest")
	public String interest() {
			return "mainpage/interest";
	}
	@RequestMapping("member/mychecklist")
	public String mychecklist() {
			return "member/mychecklist";
	}
	@RequestMapping("member/searchResult")
	public String searchResult(Model model) {
		 List<PostBean> posts = postService.getAllPosts();
		 List<CategoryBean> categories = categoryService.getAllCategories();
		 model.addAttribute("categories",categories);
		 model.addAttribute("posts", posts);
			return "member/searchResult";
	}
}
