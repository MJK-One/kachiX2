package controller.member;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.kachi.five.bean.ReviewBean;
import com.kachi.five.service.PurchaseService;
import com.kachi.five.service.ReviewService;


@Controller
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
 
    @Autowired
    private PurchaseService purchaseService;
    @RequestMapping(value = "/review/submit", method = RequestMethod.POST)
    public String submitReview(@RequestParam("purchaseId") int purchaseId,
                               @RequestParam("reviewContent") String content,
                               @RequestParam("rating") float rating,
                               @RequestParam("postId") int postId
                               ) {
        // 리뷰 객체 생성 및 설정
        ReviewBean review = new ReviewBean();
        review.setPurchaseID(purchaseId);
        review.setContent(content);
        review.setRating(rating);
        review.setPostID(postId);
        reviewService.insertReview(review);
        purchaseService.updatereviewWritten(purchaseId);
        return "redirect:/";
    }
}