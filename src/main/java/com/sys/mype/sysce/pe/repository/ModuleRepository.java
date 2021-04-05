package com.sys.mype.sysce.pe.repository;

import com.sys.mype.sysce.pe.model.BModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends JpaRepository<BModule, Integer> {
}
