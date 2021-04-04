package com.sys.mype.sysce.pe.repository;

import com.sys.mype.sysce.pe.model.BProduct;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<BProduct, String> {

    /**
     * PRIMERA FORMA
     * https://stackoverflow.com/questions/37178520/jpql-like-case-insensitive/62988377#62988377
     * @param productName
     * @param productStatus
     * @return
     */

    @Query("SELECT p FROM BProduct p where upper(p.productName) like upper(concat('%', ?1 ,'%')) and p.productStatus = ?2")
    public List<BProduct> findByProductName(String productName, String productStatus);


    /**
     * SEGUNDA FORMA
     * https://stackoverflow.com/questions/37178520/jpql-like-case-insensitive/62988377#62988377
     * @param productName
     * @param productStatus
     * @return
     */
    public List<BProduct> findByProductNameContainingIgnoreCaseAndProductStatus(String productName, String productStatus);


    /**
     * TERCERA FORMA
     * https://gitlab.com/-/ide/project/EloyNH/DigitalCorpBackEnd/tree/master/-/src/main/java/com/digitalcorp/repository/ClienteRepository.java/
     * https://gitlab.com/-/ide/project/EloyNH/DigitalCorpBackEnd/tree/master/-/src/main/java/com/digitalcorp/service/impl/ClienteServiceImpl.java/
     * Para que funcione este este método hay que hacer una modificación en ProductServiceImpl en el método findByProductName()
     * this.productRepository.findByProductNameLikeIgnoreCaseAndProductStatus("%"+productName+"%", SysceConstant.STATE_ACTIVE)
     * @param productName
     * @param productStatus
     * @return
     */
    public List<BProduct> findByProductNameLikeIgnoreCaseAndProductStatus(String productName, String productStatus);


}
