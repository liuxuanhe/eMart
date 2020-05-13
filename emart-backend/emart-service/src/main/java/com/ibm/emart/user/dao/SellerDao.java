package com.ibm.emart.user.dao;

import com.ibm.emart.user.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SellerDao extends JpaRepository<Seller, Integer>, JpaSpecificationExecutor<Seller> {

	@Query(nativeQuery = true, value = "SELECT * FROM eMart_seller WHERE username = :userName ")
	Seller findByUserNameAndPassword(@Param("userName") String userName);
}
