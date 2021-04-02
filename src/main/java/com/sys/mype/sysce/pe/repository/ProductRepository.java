package com.sys.mype.sysce.pe.repository;

import com.sys.mype.sysce.pe.model.BProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<BProduct, String> {
}
