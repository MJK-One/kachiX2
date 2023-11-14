package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import com.kachi.five.bean.ReviewBean;
import com.kachi.five.bean.ReviewImageBean;
import com.kachi.five.bean.UserBean;
import com.kachi.five.service.ReviewService;
import com.kachi.five.service.ReviewImageService;
import com.kachi.five.service.StorageService;

@Controller
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private ReviewImageService reviewImageService;
    
    String accessKey = "AKIA4PFYHLKYAQRQO7SQ"; // 실제 AWS Access Key
    String secretKey = "YCNMJad4dfSm+eJZ+z6g2nIlE2aC6nnBhHnmPuFh"; // 실제 AWS Secret Key
    String region = "ap-northeast-2"; // 예: "us-west-2", "ap-northeast-2" 등
    String bucketName = "gatchibucket";
    StorageService storageService =
            new StorageService(accessKey, secretKey, region, bucketName);

    @RequestMapping(value = "/review/submit", method = RequestMethod.POST)
    public String submitReview(@RequestParam("purchaseId") int purchaseId,
                               @RequestParam("reviewContent") String content,
                               @RequestParam("rating") float rating,
                               @RequestParam("postId") int postId,
                               @RequestParam("reviewImage") MultipartFile imageFile) {

	    
        // 리뷰 객체 생성 및 설정
        ReviewBean review = new ReviewBean();
        review.setPurchaseID(purchaseId);
        review.setContent(content);
        review.setRating(rating);
        review.setPostID(postId);

       

        // 이미지가 있으면 저장
        if (!imageFile.isEmpty()) {
            try {
            	 String originalFilename = imageFile.getOriginalFilename();
            	
            	 // 파일의 확장자를 추출
	    		   String extension = "";
	    		   int i = originalFilename.lastIndexOf('.');
	    		   if (i > 0) {
	    		       extension = originalFilename.substring(i+1);
	    		   }
	    		   
                // 이미지 파일을 임시 디렉토리에 저장
                File tempFile = File.createTempFile("img", ".tmp");
                imageFile.transferTo(tempFile);

                // 임시 파일을 AWS S3에 업로드
                String keyName = "reviewImage/" + UUID.randomUUID().toString() + extension;
                storageService.uploadFile(keyName, tempFile);

                tempFile.delete();  // 임시 파일 삭제

                // DB에 url을 저장하기 위해 imageUrl 생성
                String imageUrl = "https://" + bucketName + ".s3." + region + ".amazonaws.com/" + keyName;

                // ReviewImageBean 객체 생성 및 설정
                ReviewImageBean reviewImage = new ReviewImageBean();
                reviewImage.setReviewId(review.getReviewID());
                reviewImage.setImageUrl(imageUrl);
               

                // DB에 이미지 정보 저장
                reviewImageService.insetReviewImage(reviewImage);

            } catch (Exception e) {
                e.printStackTrace();
                return "error";
            }
        }
        System.out.println(review.getPurchaseID()+"," + review.getContent()+"," + review.getRating()+","+review.getPostID());
        // 리뷰 저장
        reviewService.insertReview(review);
        return "redirect:/";
    }
}