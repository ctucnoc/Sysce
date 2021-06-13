package com.sys.mype.sysce.pe.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sys.mype.sysce.pe.model.BUserSubsidiary;

@Repository
public interface UserSubsidiaryRepository extends JpaRepository<BUserSubsidiary, Integer>{

	@Query("select s from BUserSubsidiary s where s.bUser.userId=?1 and s.userSubsidiaryStatus=?2")
	public List<BUserSubsidiary> findByUserSubsidiary(String id,String status);
	
	@Query("select count(s)>0 from BUserSubsidiary s where s.bUser.userId=?1 and s.bSubsidiary.bEnterprise.enterpriseRuc=?2 and s.userSubsidiaryStatus=?3")
	public boolean existsByUserAndRuc(String userId,String ruc,String state);
}
