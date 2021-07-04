package com.sys.mype.sysce.pe.service.Impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.HrefEntityDTO;
import com.sys.mype.sysce.pe.dto.OrderDTO;
import com.sys.mype.sysce.pe.dto.request.OrderDetailRequestDTO;
import com.sys.mype.sysce.pe.dto.request.OrderRequestDTO;
import com.sys.mype.sysce.pe.errorhandler.SysceEntityNotFoundException;
import com.sys.mype.sysce.pe.errorhandler.SysceGenericServerException;
import com.sys.mype.sysce.pe.model.BConsumer;
import com.sys.mype.sysce.pe.model.BKindProduct;
import com.sys.mype.sysce.pe.model.BOrder;
import com.sys.mype.sysce.pe.model.BOrderDetail;
import com.sys.mype.sysce.pe.model.BOrderStatus;
import com.sys.mype.sysce.pe.model.BOrderType;
import com.sys.mype.sysce.pe.model.BSubsidiary;
import com.sys.mype.sysce.pe.repository.ConsumerRepository;
import com.sys.mype.sysce.pe.repository.KindProductRepository;
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
	final KindProductRepository kindProductRepository;
	final Util util;

	public OrderServiceImpl(OrderRepository orderRepository,ConsumerRepository consumerRepository,SubsidiaryRepository subsidiaryRepository,
			OrderStatusRepository orderStatusRepository,OrderTypeRepository orderTypeRepository,KindProductRepository kindProductRepository,Util util) {
		this.orderRepository = orderRepository;
		this.consumerRepository=consumerRepository;
		this.subsidiaryRepository=subsidiaryRepository;
		this.orderStatusRepository=orderStatusRepository;
		this.orderTypeRepository=orderTypeRepository;
		this.kindProductRepository=kindProductRepository;
		this.util=util;
	}

	@Override
	public HrefEntityDTO save(OrderRequestDTO dto) {
		BConsumer bConsumer=this.consumerRepository.findByConsumerIdAndConsumerStatus(dto.getConsumerId(), SysceConstant.STATE_ACTIVE).orElseThrow(()->new SysceEntityNotFoundException("not found consumer"));
		BSubsidiary bSubsidiary=this.subsidiaryRepository.findById(dto.getSubsidiaryId()).orElseThrow(()->new SysceEntityNotFoundException("not found subsidiary"));
		BOrderStatus bOrderStatus=this.orderStatusRepository.findByOrderStatusIdAndOrderStatus(SysceConstant.STATE_ORDER_STATUS_INITIAL, SysceConstant.STATE_ACTIVE).orElseThrow(()->new SysceEntityNotFoundException("not found order status"));
		BOrderType bOrderType=this.orderTypeRepository.findByOrderTypeIdAndOrderTypeStatus(dto.getOrderTypeId(), SysceConstant.STATE_ACTIVE).orElseThrow(()-> new SysceEntityNotFoundException("not found order type"));
		String generatedValue=this.orderRepository.GeneratedOrderId(dto.getSubsidiaryId()).orElseThrow(()->new SysceGenericServerException("error generated id"));
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
		bOrder.setOrderDetails(castToList(dto.getOrderDetails(),bOrder,dto.getSubsidiaryId()));
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
	
	private BOrderDetail cast(OrderDetailRequestDTO dto,BOrder bOrder,int subsidiaryId) {
		String generatedValueId=this.orderRepository.GeneratedOrderDetailId(subsidiaryId).orElseThrow(()-> new SysceGenericServerException("error generated id sub order"));
		BKindProduct bKindProduct=this.kindProductRepository.findById(dto.getKindProductId()).orElseThrow(()-> new SysceEntityNotFoundException("kind product not found"));
		BOrderDetail bOrderDetail=new BOrderDetail();
		bOrderDetail.setOrderDetailId(generatedValueId);
		bOrderDetail.setOrderDetailAmount(dto.getAmount());
		bOrderDetail.setOrderDetailDiscount(dto.getDiscount());
		bOrderDetail.setOrderDetailUnitPreci(dto.getUnitPreci());
		bOrderDetail.setOrderDetailCount(dto.getCount());
		bOrderDetail.setProductNameSummary(dto.getProductName());
		bOrderDetail.setOrderDetailNetAmount(dto.getNetAmount());
		bOrderDetail.setBOrder(bOrder);
		bOrderDetail.setBKindProduct(bKindProduct);
		return bOrderDetail;
	}
	
	protected List<BOrderDetail> castToList(List<OrderDetailRequestDTO> lis,BOrder bOrder,int subsidiaryId){
		return lis.stream().map((bean)->cast(bean, bOrder, subsidiaryId))
		.collect(Collectors.toList());
	}
		
}
