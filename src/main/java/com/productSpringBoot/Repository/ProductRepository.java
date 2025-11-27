package com.productSpringBoot.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.productSpringBoot.Entity.ProductInfo;

@Repository
public interface ProductRepository extends JpaRepository<ProductInfo, Integer>{

	boolean existsByprodID(int prodID);
	
	@Query("select p from ProductInfo p where concat(p.prodID, p.prodName, p.prodQty, p.prodPrice)like %?1%")
	public List<ProductInfo> search(String keyword);


}
