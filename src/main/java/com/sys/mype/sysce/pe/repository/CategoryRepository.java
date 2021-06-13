package com.sys.mype.sysce.pe.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sys.mype.sysce.pe.model.BCategory;

@Repository
public interface CategoryRepository extends JpaRepository<BCategory, Integer> {
	
	@Query("select c from BCategory c where c.categoryId=?1 and c.categoryStatus=?2")
	public Optional<BCategory> findByIdAndState(int id,String state);
}
