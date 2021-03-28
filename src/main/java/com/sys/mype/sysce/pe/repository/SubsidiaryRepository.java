package com.sys.mype.sysce.pe.repository;

import com.sys.mype.sysce.pe.model.BSubsidiary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubsidiaryRepository extends JpaRepository<BSubsidiary,Integer> {
}
