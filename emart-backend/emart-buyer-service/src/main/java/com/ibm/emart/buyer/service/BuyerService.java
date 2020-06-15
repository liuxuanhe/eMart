package com.ibm.emart.buyer.service;

import java.util.List;
import com.ibm.emart.buyer.entity.Items;
import com.ibm.emart.buyer.entity.PurchaseHistory;

public interface BuyerService {

  List<Items> searchItems(String itemName);

  List<Items> filterItems(String itemName, double fromPrice, double toPrice);

  List<PurchaseHistory> searchPurchaseHistory(String buyerName);

}
