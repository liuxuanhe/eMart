package com.ibm.emart.buyer.dao;

import com.ibm.emart.buyer.entity.PurchaseHistory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PurchaseHistoryDao extends JpaRepository<PurchaseHistory, Integer>, JpaSpecificationExecutor<PurchaseHistory> {

	@Query(nativeQuery = true, value = "SELECT P.* FROM eMart_purchase_history Purchase, buyer Buyer where Purchase.buyer_id = Buyer.id AND Buyer.username = :buyerName ")
	List<PurchaseHistory> findAll(@Param("buyerName") String buyerName);
	
}
