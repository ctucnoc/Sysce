package com.sys.mype.sysce.pe.repository;

import com.sys.mype.sysce.pe.dao.GenericDAO;
import com.sys.mype.sysce.pe.model.BProduct;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<BProduct, String>,GenericDAO{

    @Query("SELECT p FROM BProduct p where upper(p.productName) like upper(concat('%', ?1 ,'%')) and p.productStatus = ?2")
    public List<BProduct> findByProductName(String productName, String productStatus);

    public List<BProduct> findByProductNameContainingIgnoreCaseAndProductStatus(String productName, String productStatus);

    public List<BProduct> findByProductNameLikeIgnoreCaseAndProductStatus(String productName, String productStatus);

}
