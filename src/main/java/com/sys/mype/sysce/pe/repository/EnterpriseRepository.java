package com.sys.mype.sysce.pe.repository;

import com.sys.mype.sysce.pe.model.BEnterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseRepository extends JpaRepository<BEnterprise,Integer> {
}
