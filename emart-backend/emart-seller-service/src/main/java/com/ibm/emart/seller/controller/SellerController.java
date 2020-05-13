package com.ibm.emart.seller.controller;

import com.ibm.emart.seller.dto.ApiResponse;
import com.ibm.emart.seller.entity.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ibm.emart.seller.service.SellerService;

@RestController
@RequestMapping("/api/seller")
public class SellerController {
	
	@Autowired
	private SellerService sellerService;
	
	@PostMapping("addItems")
	public ApiResponse addItems(@RequestBody Items items) {
		
		ApiResponse response = new ApiResponse();
		try {
			sellerService.saveItems(items);
			response.setResponseCode(ApiResponse.SUCCESS);
			response.setResponseMessage("ok");
		} catch (Exception e) {
			response.setResponseCode(ApiResponse.ERROR);
			response.setResponseMessage("error");
		}
		return response;
	}
	
	@PostMapping("deleteItems")
	public ApiResponse deleteItems(@RequestBody Items items) {
		
		ApiResponse response = new ApiResponse();
		try {
			sellerService.deleteItems(items);
			response.setResponseCode(ApiResponse.SUCCESS);
			response.setResponseMessage("ok");
		} catch (Exception e) {
			response.setResponseCode(ApiResponse.ERROR);
			response.setResponseMessage("error");
		}
		return response;
	}
	
	@PostMapping("updateItemStock")
	public ApiResponse updateItemStock(@RequestBody Items items) {
		
		ApiResponse response = new ApiResponse();
		try {
			sellerService.updateItemStock(items.getStockNumber(), items.getItemName());
			response.setResponseCode(ApiResponse.SUCCESS);
			response.setResponseMessage("ok");
		} catch (Exception e) {
			response.setResponseCode(ApiResponse.ERROR);
			response.setResponseMessage("error");
		}
		return response;
	}
	
	@PostMapping("viewStock")
	public ApiResponse viewStock(@RequestBody Items items) {
		
		ApiResponse response = new ApiResponse();
		try {
			sellerService.viewStock(items.getItemName());
			response.setResponseCode(ApiResponse.SUCCESS);
			response.setResponseMessage("ok");
		} catch (Exception e) {
			response.setResponseCode(ApiResponse.ERROR);
			response.setResponseMessage("error");
		}
		return response;
	}

}
