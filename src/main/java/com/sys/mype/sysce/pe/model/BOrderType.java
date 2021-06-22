package com.sys.mype.sysce.pe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "order_type",schema = "sysce")
@Data
public class BOrderType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_order_type")
	private int orderTypeId;
	
	@Column(name = "ds_order_type",length = 30)
	private String orderTypeDescription;
	
	@Column(name = "sn_active",length = 1)
	private String orderTypeStatus;
}
