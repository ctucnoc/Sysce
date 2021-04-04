package com.sys.mype.sysce.pe.repository;

import com.sys.mype.sysce.pe.model.BUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<BUser,String> {
}
