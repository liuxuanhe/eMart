package com.ibm.emart.buyer.controller;

import com.ibm.emart.buyer.entity.Items;
import com.ibm.emart.buyer.entity.PurchaseHistory;
import com.ibm.emart.buyer.service.BuyerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ibm.emart.buyer.dto.ApiResponse;

@RestController
@RequestMapping("/api/buyer")
public class BuyerController {

  @Autowired
  private BuyerService buyerService;

  @PostMapping("searchItems")
  public ApiResponse searchItems(@RequestParam String itemName) {

    ApiResponse response = new ApiResponse();
    try {
      List<Items> itemList = buyerService.searchItems(itemName);
      response.setItemList(itemList);
      response.setResponseCode(ApiResponse.SUCCESS);
      response.setResponseMessage("Success");
    } catch (Exception e) {
      response.setResponseCode(ApiResponse.ERROR);
      response.setResponseMessage("Fail");
    }
    return response;
  }

  @PostMapping("filterItems")
  public ApiResponse filterItems(@RequestParam String itemName, @RequestParam double fromPrice,
      @RequestParam double toPrice) {

    ApiResponse response = new ApiResponse();
    try {
      List<Items> itemList = buyerService.filterItems(itemName, fromPrice, toPrice);

      response.setItemList(itemList);
      response.setResponseCode(ApiResponse.SUCCESS);
      response.setResponseMessage("Success");
    } catch (Exception e) {
      response.setResponseCode(ApiResponse.ERROR);
      response.setResponseMessage("Fail");
    }
    return response;
  }

  @PostMapping("searchpurchaseHistory")
  public ApiResponse searchpurchaseHistory(@RequestParam String buyerName) {

    ApiResponse response = new ApiResponse();
    try {
      List<PurchaseHistory> purchaseHistoryList = buyerService.searchPurchaseHistory(buyerName);

      response.setPurchaseHistoryList(purchaseHistoryList);
      response.setResponseCode(ApiResponse.SUCCESS);
      response.setResponseMessage("Success");
    } catch (Exception e) {
      response.setResponseCode(ApiResponse.ERROR);
      response.setResponseMessage("Fail");
    }
    return response;
  }

}
