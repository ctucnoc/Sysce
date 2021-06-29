package com.sys.mype.sysce.pe.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sys.mype.sysce.pe.dao.GenericDAO;
import com.sys.mype.sysce.pe.model.BConsumer;

@Repository
public interface ConsumerRepository extends JpaRepository<BConsumer, String>,GenericDAO{
	public Optional<BConsumer> findByConsumerIdAndConsumerStatus(String id,String status);
	
	@Query("select count(c)>0 from BConsumer c where c.consumerName=?1 and c.consumerLastName=?2 and c.consumerStatus=?3")
	public boolean existsByFullNameAndStatus(String name, String lastName,String status);
}
