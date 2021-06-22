package com.sys.mype.sysce.pe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "order_canceled",schema = "sysce")
@Data
public class BOrderCanceled {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_order_canceled")
	private int orderCanceledId;
	
	@Column(name = "ds_order_canceled",length = 30)
	private String orderCanceledDescription;
	
	@Column(name = "sn_active",length = 1)
	private String orderCanceledStatus;

}
