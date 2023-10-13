package controller.post;	

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kachi.five.DAO.MainImageDAO;
import com.kachi.five.bean.CategoryBean;
import com.kachi.five.bean.ContentImageBean;
import com.kachi.five.bean.MainImageBean;
import com.kachi.five.bean.PostBean;
import com.kachi.five.bean.UserBean;
import com.kachi.five.service.CategoryService;
import com.kachi.five.service.ContentImageService;
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

	@Autowired 
	private ContentImageService contentImgService;
	
	String accessKey = "AKIA4PFYHLKYAQRQO7SQ"; // 실제 AWS Access Key
    String secretKey = "YCNMJad4dfSm+eJZ+z6g2nIlE2aC6nnBhHnmPuFh"; // 실제 AWS Secret Key
    String region = "ap-northeast-2"; // 예: "us-west-2", "ap-northeast-2" 등
    String bucketName = "gatchibucket";
    StorageService storageService =
            new StorageService(accessKey, secretKey, region, bucketName);
    
    
	@RequestMapping("/postform")
	public String postform() {
			return "postform";
	}
	@RequestMapping("/post/post_create")
	public String createPost(Model model) {
		 List<CategoryBean> categories = categoryService.getAllCategories();
		 model.addAttribute("categories", categories);
		 
			return "/post/post_create";
	}
	
	@RequestMapping("/post/view/{postId}")
	public String viewPost(@PathVariable int postId, Model model) {
	    PostBean post = postService.getPostById(postId);
	    model.addAttribute("post", post);
	    
	    return "/post/view/view_post";
	}

	
	@RequestMapping(value = "/post/upload_image.do", method = RequestMethod.POST)
	@ResponseBody  
	public String uploadImage(@RequestParam("upload") MultipartFile multipartFile) {

		try {
			String originalFilename = multipartFile.getOriginalFilename(); 

			// 확장자 추출
			String extension = "";
			int i = originalFilename.lastIndexOf('.');
			if (i > 0) {
				extension = originalFilename.substring(i+1);
			}

			 // 1. 임시 디렉토리에 저장
			 File tempFile = File.createTempFile("img", ".tmp");
			 multipartFile.transferTo(tempFile);

			 // 2. AWS S3에 업로드
			 String keyName = "contentImage/" + UUID.randomUUID().toString() + "." + extension; 

			 storageService.uploadFile(keyName, tempFile);

			 tempFile.delete();  

			  // 3.DB 에 url 을 저장하기 위해 imageUrl 생성 
			  String imageUrl= "https://" + bucketName + ".s3." + region + ".amazonaws.com/" + keyName; 

			  
			  // ContentImageBean 객체 생성 및 설정
		      ContentImageBean contentImg = new ContentImageBean();
		      contentImg.setImageUrl(imageUrl);
	        
	          // 아직 postId가 결정되지 않았으므로 임시적으로 -1 의 값을준다. 
	          contentImg.setPostId(-1);  
	          
	          //DB에 이미지 정보 저장
	          contentImgService.insertContentImage(contentImg);
	          
			

	       // 4. CKEditor에서 요구하는 JSON 형식으로 결과를 반환
			  String jsonResponse = "{\"uploaded\" : 1, \"fileName\" : \"" + originalFilename + "\", \"url\" : \"" + imageUrl+ "\"}";
			  
			  return jsonResponse;

		 } catch (Exception e) {
		   e.printStackTrace();
		   return "error";
		 }
	}

	
	@RequestMapping(value = "/post/create_submit", method = RequestMethod.POST)
	public String createPost_Submit(@ModelAttribute PostBean post, 
			HttpServletRequest request, 
			@RequestParam("image") MultipartFile imageFile) {
		
		HttpSession session = request.getSession();
	    UserBean user = (UserBean) session.getAttribute("loggedInUser");

	    if (user != null) {
	    	 try {
	    		 String originalFilename = imageFile.getOriginalFilename(); //파일의 이름을 가져온다.
	    		 
	    		// 파일의 확장자를 추출
	    		   String extension = "";
	    		   int i = originalFilename.lastIndexOf('.');
	    		   if (i > 0) {
	    		       extension = originalFilename.substring(i+1);
	    		   }
	    		   
	             // 1. 사용자가 업로드한 파일을 서버의 임시 디렉토리에 저장
	             File tempFile = File.createTempFile("img", ".tmp");
	             imageFile.transferTo(tempFile);

	             // 2. 임시 파일을 AWS S3에 업로드
	             	                         
		 	    // 여기서 keyName은 원하는 대로 설정할 수 있습니다.
		 	    // 일반적으로 postId나 UUID 등 유니크한 값을 포함하게 만듭니다.
		        String keyName = "mainImage/" + UUID.randomUUID().toString() + "." + extension; 
	
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

	        contentImgService.updateContentImagesWithPostId(-1, post.getPostId());
	        return "redirect:/";
	    } else {
	        // 사용자가 로그인하지 않은 상태에서 글을 작성하려는 경우 처리
	       
	        return "redirect:/login";  
	    }
	}
}