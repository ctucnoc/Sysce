package com.sys.mype.sysce.pe.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sys.mype.sysce.pe.model.BKindSale;

@Repository
public interface KindSaleRepository extends JpaRepository<BKindSale, Integer>{
	
    public List<BKindSale> findByKindSaleDescriptionLikeIgnoreCaseAndKindSaleStatus(String description,String status);
    
    public Optional<BKindSale> findByKindSaleIdAndKindSaleStatus(int id,String status);
    

}
