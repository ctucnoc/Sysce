package com.sys.mype.sysce.pe.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "consumer",schema = "sysce")
@Data
public class BConsumer {
	@Id
	@Column(name = "cd_consumer",length = 15)
	private String consumerId;
	
	@Column(name = "nm_consumer",length = 30)
	private String consumerName;
	
	@Column(name = "nm_last",length = 60)
	private String consumerLastName;
	
	@Column(name = "qt_visit")
	private int consumerAmountVisit;
	
	@Column(name = "nr_cell",length = 11)
	private String consumerCell;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_birthday")
	private Date consumerBirthday;
	
	@Column(name = "ds_direction",length = 90)
	private String consumerDirection;
	
	@Column(name = "sn_active")
	private String consumerStatus;
	
	@ManyToOne
	@JoinColumn(name = "cd_subsidiary")
	private BSubsidiary bSubsidiary;
}
