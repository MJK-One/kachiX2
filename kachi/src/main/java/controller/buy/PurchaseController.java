package controller.buy;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kachi.five.bean.AddressBean;
import com.kachi.five.bean.GroupBuyBean;
import com.kachi.five.bean.PostBean;
import com.kachi.five.bean.PurchaseBean;
import com.kachi.five.bean.UserBean;
import com.kachi.five.service.GroupBuyService;
import com.kachi.five.service.PostService;
import com.kachi.five.service.PurchaseService;
import com.kachi.five.service.UserService;
@Controller
public class PurchaseController {
      @Autowired
       private PurchaseService purchaseService;
      @Autowired 
      private GroupBuyService groupBuyService;
       @Autowired 
       private PostService postService;
       @Autowired
       private UserService userService;
      
      @RequestMapping("member/purchase")
      public String purchase(@RequestParam("postId") int postId, 
            @RequestParam("quantity") int quantity, 
               @RequestParam("totalPrice") int totalPrice, Model model, HttpServletRequest request , HttpServletResponse response) {
         
         response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
          response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
          response.setDateHeader("Expires", 0); // Proxies.
             
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
      public String purchase_join(@RequestParam("postId1") int postId, 
            @RequestParam("quantity1") int quantity, 
               @RequestParam("totalPrice1") int totalPrice,
               @RequestParam("groupBuyID1") int groupBuyId, Model model, HttpServletRequest request, HttpServletResponse response) {
         
         response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
          response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
          response.setDateHeader("Expires", 0); // Proxies.
          
         HttpSession session = request.getSession();
         UserBean user = (UserBean) session.getAttribute("loggedInUser");
         if(user == null) return "member/loginForm"; //로그인이 안되어있으면 로그인 폼으로 이동}
         
         List<AddressBean> addresses = userService.getAddresses(user.getUserID());
          model.addAttribute("addresses", addresses);
          
         PostBean post = postService.getPostById(postId);
         model.addAttribute("post", post);
         model.addAttribute("totalPrice", totalPrice);
         model.addAttribute("quantity", quantity);
         model.addAttribute("groupBuyId", groupBuyId);
         model.addAttribute("user", user);
            return "member/purchase_join";
      }
      
      @PostMapping("/purchase")
      public String createPurchase(@RequestBody PurchaseBean purchase ,  HttpServletResponse response) {
         
         
          
          GroupBuyBean groupBuy = groupBuyService.getGroupBuy(purchase.getGroupBuyId());
          if (purchase.getGroupBuyId() == 0) {
              // groupBuyId 값이 0인 경우 예외를 발생시킵니다.
              throw new IllegalArgumentException("Invalid groupBuyId: " + purchase.getGroupBuyId());
          }

          purchaseService.createPurchase(purchase);

          return "redirect:/";
      }
}