package com.sys.mype.sysce.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sys.mype.sysce.pe.model.BKindProduct;

@Repository
public interface KindProductRepository extends JpaRepository<BKindProduct, Long>{
	
	@Query("select count(k)>0 from BKindProduct k where k.bProduct.productId=?1 and k.bKindSale.kindSaleId=?2")
	public boolean existsByProductIdAndKindSaleId(String productId,int kindSaleId);

}
