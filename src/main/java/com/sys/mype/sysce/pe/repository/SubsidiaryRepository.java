package com.sys.mype.sysce.pe.repository;

import com.sys.mype.sysce.pe.model.BSubsidiary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SubsidiaryRepository extends JpaRepository<BSubsidiary,Integer> {

    @Query("select s from BSubsidiary s where s.bEnterprise.enterpriseId=?1 and s.subsidiaryStatus=?2")
    public List<BSubsidiary> findAllByEnterpriseId(int id,String status);
    
}
