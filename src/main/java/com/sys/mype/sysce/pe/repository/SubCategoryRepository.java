package com.sys.mype.sysce.pe.repository;

import com.sys.mype.sysce.pe.model.BSubCategory;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryRepository extends CrudRepository<BSubCategory, Integer> {

	@Query("select c from BSubCategory c where c.bCategory.categoryId=?1 and c.subCategoryStatus=?2")
	public List<BSubCategory> findSubCategoryByCategoryId(int categoryId, String status);
}
