package com.sys.mype.sysce.pe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
@Entity
@Table(name = "order_detail",schema = "sysce")
public class BOrderDetail {

	@Id
	@Column(name = "cd_order_detail",length = 16)
	private String orderDetailId;
	
	@Column(name = "qt_count")
	private int orderDetailCount;
	
	@Column(name = "qt_amount")
	private double orderDetailAmount;
	
	@Column(name = "qt_unitPreci")
	private double orderDetailUnitPreci;
	
	@Column(name = "qt_discount")
	private double orderDetailDiscount;
	
	@Column(name = "qt_netAmount")
	private double orderDetailNetAmount;
	
	@Column(name = "nm_product_summary",length = 30)
	private String productNameSummary;
	
	@ManyToOne
	@JoinColumn(name = "cd_order")
	@JsonIgnore
	private BOrder bOrder;
	
	@ManyToOne
	@JoinColumn(name = "cd_kind_product")
	private BKindProduct bKindProduct;
}
