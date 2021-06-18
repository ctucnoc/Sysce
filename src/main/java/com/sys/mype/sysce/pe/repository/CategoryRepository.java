package com.sys.mype.sysce.pe.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sys.mype.sysce.pe.model.BCategory;

@Repository
public interface CategoryRepository extends JpaRepository<BCategory, Integer> {
	
	@Query("select c from BCategory c where c.categoryId=?1 and c.categoryStatus=?2")
	public Optional<BCategory> findByIdAndState(int id,String state);
	
	@Query("select c from BCategory c where c.categoryDescription like CONCAT('%',UPPER(?1),'%') and c.categoryStatus=?2")
	public List<BCategory> findByCategoryDescriptionAndCategoryStatus(String key_word,String state);

	//public List<BCategory> findBCategoryByCategoryDescriptionAndCategoryStatus(String key_word,String state);
}
