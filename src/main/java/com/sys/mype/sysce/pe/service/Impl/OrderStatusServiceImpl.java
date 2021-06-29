package com.sys.mype.sysce.pe.service.Impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.GenericDTO;
import com.sys.mype.sysce.pe.dto.HrefEntityDTO;
import com.sys.mype.sysce.pe.dto.request.OrderStatusRequestDTO;
import com.sys.mype.sysce.pe.errorhandler.SysceEntityNotFoundException;
import com.sys.mype.sysce.pe.model.BOrderStatus;
import com.sys.mype.sysce.pe.repository.OrderStatusRepository;
import com.sys.mype.sysce.pe.service.OrderStatusService;
import com.sys.mype.sysce.pe.util.SysceResources;
import com.sys.mype.sysce.pe.util.Util;

@Service
@Transactional
public class OrderStatusServiceImpl implements OrderStatusService{

	final OrderStatusRepository orderStatusRepository;

	public OrderStatusServiceImpl(OrderStatusRepository orderStatusRepository) {
		super();
		this.orderStatusRepository = orderStatusRepository;
	}

	@Override
	public HrefEntityDTO save(OrderStatusRequestDTO dto) {
		BOrderStatus bOrderStatus=new BOrderStatus();
		bOrderStatus.setOrderStatusDescription(dto.getDescription());
		bOrderStatus.setOrderStatus(SysceConstant.STATE_ACTIVE);
		return Util.createHrefFromResource(this.orderStatusRepository.save(bOrderStatus).getOrderStatusId(), SysceResources.ORDERSTATUS);
	}

	@Override
	public HrefEntityDTO update(OrderStatusRequestDTO dto, int id) {
		BOrderStatus bOrderStatus=this.orderStatusRepository.findByOrderStatusIdAndOrderStatus(id, SysceConstant.STATE_ACTIVE).orElseThrow(()->new SysceEntityNotFoundException("not found order status"));
		bOrderStatus.setOrderStatusDescription(dto.getDescription());
		return Util.createHrefFromResource(this.orderStatusRepository.save(bOrderStatus).getOrderStatusId(), SysceResources.ORDERSTATUS);
	}

	@Override
	public GenericDTO findById(int id) {
		BOrderStatus bOrderStatus=this.orderStatusRepository.findByOrderStatusIdAndOrderStatus(id, SysceConstant.STATE_ACTIVE).orElseThrow(()->new SysceEntityNotFoundException("not found order status"));
		GenericDTO dto=new GenericDTO();
		dto.setDescription(bOrderStatus.getOrderStatusDescription());
		dto.setId(bOrderStatus.getOrderStatusId());
		return dto;
	}

	@Override
	public List<GenericDTO> findAll() {
		return this.orderStatusRepository.findByOrderStatus(SysceConstant.STATE_ACTIVE).stream()
				.map((bean)-> new GenericDTO(bean.getOrderStatusId(), bean.getOrderStatusDescription()))
				.collect(Collectors.toList());
	}
	
}
