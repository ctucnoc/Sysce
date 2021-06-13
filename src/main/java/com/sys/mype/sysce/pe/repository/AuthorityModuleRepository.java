package com.sys.mype.sysce.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sys.mype.sysce.pe.model.BAuthorityModule;

@Repository
public interface AuthorityModuleRepository extends JpaRepository<BAuthorityModule, Integer>{

}
