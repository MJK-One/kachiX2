package controller.buy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.kachi.five.bean.GroupBuyBean;
import com.kachi.five.bean.PurchaseBean;
import com.kachi.five.service.GroupBuyService;
import com.kachi.five.service.PurchaseService;
@Controller
public class PurchaseController {
		@Autowired
	    private PurchaseService purchaseService;
		@Autowired 
		private GroupBuyService groupBuyService;
		@PostMapping("/purchase")
		public ResponseEntity<?> createPurchase(@RequestBody PurchaseBean purchase) {
		    GroupBuyBean groupBuy = groupBuyService.getGroupBuy(purchase.getGroupBuyId());
		    if (purchase.getGroupBuyId() == 0) {
		        // groupBuyId 값이 0인 경우 예외를 발생시킵니다.
		        throw new IllegalArgumentException("Invalid groupBuyId: " + purchase.getGroupBuyId());
		    }

		    purchaseService.createPurchase(purchase);

		    return new ResponseEntity<>(HttpStatus.CREATED);
		}
}
