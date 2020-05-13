package com.ibm.emart.seller.dao;

import com.ibm.emart.seller.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SellerDao extends JpaRepository<Items, Integer>, JpaSpecificationExecutor<Items> {

	@Query(nativeQuery = true, value = "UPDATE eMart_items SET stock_number = :stockNumber WHERE item_name = :itemName ")
	void updateItemStock(@Param("stockNumber") int number, @Param("itemName")String itemName);

	@Query(nativeQuery = true, value = "SEARCH * FROM eMart_items WHERE item_name = :itemName ")
	Items viewStock(@Param("itemName")String itemName);

}
