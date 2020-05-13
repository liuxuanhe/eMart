package com.ibm.emart.seller.service.impl;

import com.ibm.emart.seller.dao.SellerDao;
import com.ibm.emart.seller.entity.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.emart.seller.service.SellerService;

@Service
public class SellerServiceImpl implements SellerService {

  @Autowired
  private SellerDao sellerDao;

  @Override
  public void saveItems(Items items) {
    sellerDao.save(items);
  }

  @Override
  public void deleteItems(Items items) {
    sellerDao.delete(items);
  }

  @Override
  public void deleteItems(int itemId) {
    sellerDao.deleteById(itemId);
  }

  @Override
  public void updateItemStock(int number, String itemName) {
    sellerDao.updateItemStock(number, itemName);
  }

  @Override
  public Items viewStock(String itemName) {
    return sellerDao.viewStock(itemName);
  }

}
