package com.sys.mype.sysce.pe.repository;

import com.sys.mype.sysce.pe.model.BPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<BPerson, Integer> {
}
