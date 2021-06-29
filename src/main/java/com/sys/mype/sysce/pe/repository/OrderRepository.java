package com.sys.mype.sysce.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sys.mype.sysce.pe.dao.GenericDAO;
import com.sys.mype.sysce.pe.model.BOrder;

@Repository
public interface OrderRepository extends JpaRepository<BOrder, String>,GenericDAO{

}
