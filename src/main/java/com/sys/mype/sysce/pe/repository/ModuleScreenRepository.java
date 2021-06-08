package com.sys.mype.sysce.pe.repository;

import com.sys.mype.sysce.pe.model.BModuleScreen;
import com.sys.mype.sysce.pe.model.BPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleScreenRepository extends JpaRepository<BModuleScreen, Integer> {

}
