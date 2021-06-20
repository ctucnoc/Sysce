package com.sys.mype.sysce.pe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "kind_product",schema = "sysce")
@Data
public class BKindProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_kind_product")
	private Long kindProductId;
	
	@Column(name = "qt_price")
	private double kindProductPrice;
	
	@Column(name = "qt_orders")
	private Long kindProductCantOrders;
	
	@Column(name = "sn_active")
	private String kindProductStatus;
	
	@ManyToOne
	@JoinColumn(name = "cd_product")
	private BProduct bProduct;
	
	@ManyToOne
	@JoinColumn(name = "cd_kind_sale")
	private BKindSale bKindSale;

}
