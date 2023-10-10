package controller.post;	

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kachi.five.DAO.MainImageDAO;
import com.kachi.five.bean.CategoryBean;
import com.kachi.five.bean.MainImageBean;
import com.kachi.five.bean.PostBean;
import com.kachi.five.bean.UserBean;
import com.kachi.five.service.CategoryService;
import com.kachi.five.service.MainImageService;
import com.kachi.five.service.PostService;
import com.kachi.five.service.StorageService;

@Controller
public class PostController {
	@Autowired 
	private PostService postService;
	@Autowired  
	private CategoryService categoryService;
	@Autowired
	private MainImageService mainImgService;
	
	@RequestMapping("/postform")
	public String postform() {
			return "postform";
	}
	@RequestMapping("/post/create")
	public String createPost(Model model) {
		 List<CategoryBean> categories = categoryService.getAllCategories();
		 model.addAttribute("categories", categories);
		 
			return "/post/create";
	}
	
	@RequestMapping(value = "/post/create_submit", method = RequestMethod.POST)
	public String createPost_Submit(@ModelAttribute PostBean post, HttpServletRequest request, @RequestParam("image") MultipartFile imageFile) {
		HttpSession session = request.getSession();
	    UserBean user = (UserBean) session.getAttribute("loggedInUser");

	    if (user != null) {
	    	 try {
	             // 1. 사용자가 업로드한 파일을 서버의 임시 디렉토리에 저장
	             File tempFile = File.createTempFile("img", ".tmp");
	             imageFile.transferTo(tempFile);

	             // 2. 임시 파일을 AWS S3에 업로드
	             String accessKey = "AKIA4PFYHLKYAQRQO7SQ"; // 실제 AWS Access Key
	             String secretKey = "YCNMJad4dfSm+eJZ+z6g2nIlE2aC6nnBhHnmPuFh"; // 실제 AWS Secret Key
	             String region = "ap-northeast-2"; // 예: "us-west-2", "ap-northeast-2" 등
	             String bucketName = "gatchibucket";

	             StorageService storageService =
	                     new StorageService(accessKey, secretKey, region, bucketName);
	             
	 	    // 여기서 keyName은 원하는 대로 설정할 수 있습니다.
	 	    // 일반적으로 postId나 UUID 등 유니크한 값을 포함하게 만듭니다.
	 	    String keyName = "mainImage/" + UUID.randomUUID().toString(); 

	 	    storageService.uploadFile(keyName, tempFile);

	 	    tempFile.delete();  // 임시 파일 삭제

	 	    // 3. DB 에 url 을 저장하기 위해 imageUrl 생성 후 Post 객체의 적절한 필드 설정 
	 	    post.setMainImageUrl("https://" + bucketName + ".s3." + region + ".amazonaws.com/" + keyName);
	 	    
	 	 
	 	   
	         } catch (Exception e) {
	            e.printStackTrace();
	            return "error";
	         }
	    	
	    	
	        post.setWriterId(user.getUserID());
	        post.setSaleStatus(true);
	        postService.createPost(post);
	        
	        MainImageBean img = new MainImageBean();
	    	img.setPostId(post.getPostId());  
	    	img.setImageUrl(post.getMainImageUrl()); 
	        mainImgService.insertMainImage(img);
	        
	        return "redirect:/";
	    } else {
	        // 사용자가 로그인하지 않은 상태에서 글을 작성하려는 경우 처리
	       
	        return "redirect:/login";  
	    }
	}
}