package com.ibm.emart.buyer.dto;

import com.ibm.emart.buyer.entity.Items;
import com.ibm.emart.buyer.entity.PurchaseHistory;
import java.util.List;

import lombok.Data;

@Data
public class ApiResponse {

	public static final String SUCCESS = "200";
	public static final String ERROR = "404";
	private String responseCode;
	private String responseMessage;
	private String token;
	private List<Items> itemList;
	private List<PurchaseHistory> purchaseHistoryList;

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<Items> getItemList() {
		return itemList;
	}

	public void setItemList(List<Items> itemList) {
		this.itemList = itemList;
	}

	public List<PurchaseHistory> getPurchaseHistoryList() {
		return purchaseHistoryList;
	}

	public void setPurchaseHistoryList(
			List<PurchaseHistory> purchaseHistoryList) {
		this.purchaseHistoryList = purchaseHistoryList;
	}
}
