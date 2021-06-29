package com.sys.mype.sysce.pe.service.Impl;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.HrefEntityDTO;
import com.sys.mype.sysce.pe.dto.OrderDTO;
import com.sys.mype.sysce.pe.dto.request.OrderRequestDTO;
import com.sys.mype.sysce.pe.errorhandler.SysceEntityNotFoundException;
import com.sys.mype.sysce.pe.model.BConsumer;
import com.sys.mype.sysce.pe.model.BOrder;
import com.sys.mype.sysce.pe.model.BOrderStatus;
import com.sys.mype.sysce.pe.model.BOrderType;
import com.sys.mype.sysce.pe.model.BSubsidiary;
import com.sys.mype.sysce.pe.repository.ConsumerRepository;
import com.sys.mype.sysce.pe.repository.OrderRepository;
import com.sys.mype.sysce.pe.repository.OrderStatusRepository;
import com.sys.mype.sysce.pe.repository.OrderTypeRepository;
import com.sys.mype.sysce.pe.repository.SubsidiaryRepository;
import com.sys.mype.sysce.pe.service.OrderService;
import com.sys.mype.sysce.pe.util.SysceResources;
import com.sys.mype.sysce.pe.util.Util;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{

	final OrderRepository orderRepository;
	final ConsumerRepository consumerRepository;
	final SubsidiaryRepository subsidiaryRepository;
	final OrderStatusRepository orderStatusRepository;
	final OrderTypeRepository orderTypeRepository;
	final Util util;

	public OrderServiceImpl(OrderRepository orderRepository,ConsumerRepository consumerRepository,SubsidiaryRepository subsidiaryRepository,
			OrderStatusRepository orderStatusRepository,OrderTypeRepository orderTypeRepository,Util util) {
		this.orderRepository = orderRepository;
		this.consumerRepository=consumerRepository;
		this.subsidiaryRepository=subsidiaryRepository;
		this.orderStatusRepository=orderStatusRepository;
		this.orderTypeRepository=orderTypeRepository;
		this.util=util;
	}

	@Override
	public HrefEntityDTO save(OrderRequestDTO dto) {
		BConsumer bConsumer=this.consumerRepository.findByConsumerIdAndConsumerStatus(dto.getConsumerId(), SysceConstant.STATE_ACTIVE).orElseThrow(()->new SysceEntityNotFoundException("not found consumer"));
		BSubsidiary bSubsidiary=this.subsidiaryRepository.findById(dto.getSubsidiaryId()).orElseThrow(()->new SysceEntityNotFoundException("not found subsidiary"));
		BOrderStatus bOrderStatus=this.orderStatusRepository.findByOrderStatusIdAndOrderStatus(SysceConstant.STATE_ORDER_STATUS_INITIAL, SysceConstant.STATE_ACTIVE).orElseThrow(()->new SysceEntityNotFoundException("not found order status"));
		BOrderType bOrderType=this.orderTypeRepository.findByOrderTypeIdAndOrderTypeStatus(dto.getOrderTypeId(), SysceConstant.STATE_ACTIVE).orElseThrow(()-> new SysceEntityNotFoundException("not found order type"));
		String generatedValue=this.orderRepository.GeneratedOrderId(dto.getSubsidiaryId()).orElseThrow(()->new SysceEntityNotFoundException("error generated id"));
		BOrder bOrder=new BOrder();
		bOrder.setOrderId(generatedValue);
		bOrder.setOrderTotalDiscount(dto.getTotalDiscount());
		bOrder.setOrderTotalImposition(dto.getTotalImposition());
		bOrder.setOrderTotalNetAmount(dto.getTotalNetAmount());
		bOrder.setOrderTotalPrice(dto.getTotalPrice());
		bOrder.setBConsumer(bConsumer);
		bOrder.setBOrderStatus(bOrderStatus);
		bOrder.setBOrderType(bOrderType);
		bOrder.setBSubsidiary(bSubsidiary);
		bOrder.setOrderDateRegister(new Date());
		bOrder.setUserCreation("CTUCNOC");
		return Util.createHrefFromResource(this.orderRepository.save(bOrder).getOrderId(), SysceResources.ORDER);
	}

	@Override
	public OrderDTO findById(String id) {
		BOrder bOrder=this.orderRepository.findById(id).orElseThrow(()->new SysceEntityNotFoundException("not found order"));
		OrderDTO dto=new OrderDTO();
		dto.setId(bOrder.getOrderId());
		dto.setTotalDiscount(bOrder.getOrderTotalDiscount());
		dto.setTotalImposition(bOrder.getOrderTotalImposition());
		dto.setTotalNetAmount(bOrder.getOrderTotalNetAmount());
		dto.setTotalPrice(bOrder.getOrderTotalPrice());
		return dto;
	}
	
	
}
