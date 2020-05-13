package com.ibm.emart.buyer.dao;

import com.ibm.emart.buyer.entity.Buyer;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BuyerDao extends JpaRepository<Buyer, Integer>, JpaSpecificationExecutor<Buyer> {

	@Query(nativeQuery = true, value = "SELECT * FROM eMart_buyer WHERE username = :userName AND password = :pwd ")
	List<Buyer> findByUserNameAndPassword(@Param("userName") String userName, @Param("pwd")  String password);
	
}
