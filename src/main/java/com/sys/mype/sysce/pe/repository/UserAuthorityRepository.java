package com.sys.mype.sysce.pe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sys.mype.sysce.pe.model.BUserAuthority;

@Repository
public interface UserAuthorityRepository extends JpaRepository<BUserAuthority, Integer>{

	@Query("select a from BUserAuthority a where a.bUser.userId=?1 and a.userAuthorityStatus=?2")
	public List<BUserAuthority> findByUserAuthority(String id,String status);
}
