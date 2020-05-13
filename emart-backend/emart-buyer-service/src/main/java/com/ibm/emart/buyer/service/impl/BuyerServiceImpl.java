package com.ibm.emart.buyer.service.impl;

import com.ibm.emart.buyer.exception.DataNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ibm.emart.buyer.dao.ItemsDao;
import com.ibm.emart.buyer.dao.PurchaseHistoryDao;
import com.ibm.emart.buyer.entity.Items;
import com.ibm.emart.buyer.entity.PurchaseHistory;
import com.ibm.emart.buyer.service.BuyerService;

@Service
public class BuyerServiceImpl implements BuyerService {
	
	@Autowired
	private ItemsDao itemsDao;
	
	@Autowired
	private PurchaseHistoryDao purchaseHistoryDao;

	@Override
	public List<Items> searchItems(String itemName) throws DataNotFoundException {
		return itemsDao.findAll(itemName);
	}

	@Override
	public List<Items> filterItems(String itemName, double fromPrice, double toPrice) throws DataNotFoundException {
		return itemsDao.findAll(itemName, fromPrice, toPrice);
	}

	@Override
	public List<PurchaseHistory> searchPurchaseHistory(String buyerName) throws DataNotFoundException {
		return purchaseHistoryDao.findAll(buyerName);
	}
	
}
