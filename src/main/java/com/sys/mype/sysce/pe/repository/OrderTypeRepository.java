package com.sys.mype.sysce.pe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sys.mype.sysce.pe.model.BOrderType;

public interface OrderTypeRepository extends JpaRepository<BOrderType, Integer>{
	public Optional<BOrderType> findByOrderTypeIdAndOrderTypeStatus(int id,String status);
}
