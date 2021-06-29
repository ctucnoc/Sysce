package com.sys.mype.sysce.pe.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sys.mype.sysce.pe.model.BOrderStatus;

@Repository
public interface OrderStatusRepository extends JpaRepository<BOrderStatus, Integer>{
	public Optional<BOrderStatus> findByOrderStatusIdAndOrderStatus(int id,String status);
	public List<BOrderStatus> findByOrderStatus(String status);
}
