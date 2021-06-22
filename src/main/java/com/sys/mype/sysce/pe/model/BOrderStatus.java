package com.sys.mype.sysce.pe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "order_status",schema = "sysce")
@Data
public class BOrderStatus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_order_status")
	private int orderStatusId;
	
	@Column(name = "ds_order_status",length = 30)
	private String orderStatusDescription;
	
	@Column(name = "sn_active",length = 1)
	private String orderStatus;

}
