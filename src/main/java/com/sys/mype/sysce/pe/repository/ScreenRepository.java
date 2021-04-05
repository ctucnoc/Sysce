package com.sys.mype.sysce.pe.repository;

import com.sys.mype.sysce.pe.model.BScreen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenRepository extends JpaRepository<BScreen, Integer> {
}
