package com.sys.mype.sysce.pe.repository;

import com.sys.mype.sysce.pe.model.BEnterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnterpriseRepository extends JpaRepository<BEnterprise,Integer> {


    @Query("SELECT e FROM BEnterprise e WHERE UPPER(e.enterpriseName) LIKE UPPER(concat('%', ?1, '%')) AND e.enterpriseStatus = ?2")
    public List<BEnterprise> findByEnterpriseName(String name, String status);
}
