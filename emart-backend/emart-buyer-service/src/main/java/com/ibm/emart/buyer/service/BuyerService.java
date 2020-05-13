package com.ibm.emart.buyer.service;

import com.ibm.emart.buyer.exception.DataNotFoundException;
import java.util.List;
import com.ibm.emart.buyer.entity.Items;
import com.ibm.emart.buyer.entity.PurchaseHistory;

public interface BuyerService {

	List<Items> searchItems(String itemName) throws DataNotFoundException;
	List<Items> filterItems(String itemName, double fromPrice, double toPrice) throws DataNotFoundException;
	List<PurchaseHistory> searchPurchaseHistory(String buyerName) throws DataNotFoundException;
}
