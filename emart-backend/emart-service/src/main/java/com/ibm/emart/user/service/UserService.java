package com.ibm.emart.user.service;

import com.ibm.emart.user.entity.Buyer;
import com.ibm.emart.user.entity.Seller;

public interface UserService {

  void findBuyer(String userName, String password);
  void findSeller(String userName, String password);
  void saveBuyer(Buyer buyer);
  void saveSeller(Seller seller);

}
