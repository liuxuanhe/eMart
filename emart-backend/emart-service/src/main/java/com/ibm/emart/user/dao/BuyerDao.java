package com.ibm.emart.user.dao;

import com.ibm.emart.user.entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BuyerDao extends JpaRepository<Buyer, Integer>, JpaSpecificationExecutor<Buyer> {

  @Query(nativeQuery = true, value = "SELECT * FROM eMart_buyer WHERE username = :userName ")
  Buyer findByUserNameAndPassword(@Param("userName") String userName);

}
