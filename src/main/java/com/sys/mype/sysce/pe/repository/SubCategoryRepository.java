package com.sys.mype.sysce.pe.repository;

import com.sys.mype.sysce.pe.model.BSubCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryRepository extends CrudRepository<BSubCategory, Integer> {
}
