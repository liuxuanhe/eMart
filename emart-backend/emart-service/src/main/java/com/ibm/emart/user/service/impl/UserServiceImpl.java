package com.ibm.emart.user.service.impl;

import com.ibm.emart.user.entity.Buyer;
import com.ibm.emart.user.entity.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ibm.emart.user.dao.BuyerDao;
import com.ibm.emart.user.dao.SellerDao;
import com.ibm.emart.user.service.UserService;

import lombok.NonNull;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private BuyerDao buyerDao;

  @Autowired
  private SellerDao sellerDao;

  @Override
  public void findBuyer(@NonNull String userName, @NonNull String password) throws Exception {

    try {
      Buyer buyer = buyerDao.findByUserNameAndPassword(userName);
      if (buyer != null) {
        if (!password.equals(buyer.getPassword())) {
          throw new Exception();
        }
      }
    } catch (Exception e) {
      throw new Exception();
    }

  }

  @Override
  public void findSeller(@NonNull String userName, @NonNull String password) throws Exception {

    try {
      Seller seller = sellerDao.findByUserNameAndPassword(userName);
      if (seller != null) {
        if (!password.equals(seller.getPassword())) {
          throw new Exception();
        }
      }
    } catch (Exception e) {
      throw new Exception();
    }

  }

  @Override
  public void saveBuyer(Buyer buyer) {
    buyerDao.save(buyer);
  }

  @Override
  public void saveSeller(Seller seller) {
    sellerDao.save(seller);
  }

}
