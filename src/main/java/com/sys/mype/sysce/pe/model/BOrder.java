package com.sys.mype.sysce.pe.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "order",schema = "sysce")
@Data
public class BOrder {
	@Id
	@Column(name = "cd_order",length = 16)
	private String orderId;
	
	@Column(name = "qt_price")
	private double orderTotalPrice;
	
	@Column(name = "qt_netAmount")
	private double orderTotalNetAmount;
	
	@Column(name = "qt_discount")
	private double orderTotalDiscount;
	
	@Column(name = "qt_imposition")
	private double orderTotalImposition;
	
	@Column(name = "dt_register")
	private Date orderDateRegister;
	
	@Column(name = "dt_alter")
	private Date orderDateAlter;
	
	@Column(name = "user_creation",length = 15)
	private String userCreation;
	
	@Column(name = "user_alter",length = 15)
	private String userAlter;
	
	@ManyToOne
	@JoinColumn(name = "cd_order_type")
	private BOrderType bOrderType;
	
	@ManyToOne
	@JoinColumn(name = "cd_order_status")
	private BOrderStatus bOrderStatus;
	
	@ManyToOne
	@JoinColumn(name = "cd_consumer")
	private BConsumer bConsumer;
	
	@ManyToOne
	@JoinColumn(name = "cd_subsidiary")
	private BSubsidiary bSubsidiary;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	private List<BOrderDetail> orderDetails;
}
