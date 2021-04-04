package com.sys.mype.sysce.pe.repository;

import com.sys.mype.sysce.pe.model.BCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<BCategory, Integer> {
}
