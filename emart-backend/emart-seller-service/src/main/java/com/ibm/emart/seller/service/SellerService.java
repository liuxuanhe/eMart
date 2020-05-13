package com.ibm.emart.seller.service;

import com.ibm.emart.seller.entity.Items;

public interface SellerService {
	
	void saveItems(Items items);
	void deleteItems(Items items);
	void deleteItems(int itemId);
	void updateItemStock(int number, String itemName);
	Items viewStock(String itemName);

}
