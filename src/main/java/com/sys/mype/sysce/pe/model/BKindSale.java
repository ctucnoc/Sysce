package com.sys.mype.sysce.pe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "kind_sale",schema = "sysce")
@Data
public class BKindSale {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_kind_sale")
	private int kindSaleId;
	
	@Column(name = "ds_kind_sale",length = 30)
	private String kindSaleDescription;
	
	@Column(name = "sn_active",length = 1)
	private String kindSaleStatus;

}
