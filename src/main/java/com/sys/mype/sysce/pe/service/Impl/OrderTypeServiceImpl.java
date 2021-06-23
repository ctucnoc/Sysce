package com.sys.mype.sysce.pe.service.Impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.GenericDTO;
import com.sys.mype.sysce.pe.dto.HrefEntityDTO;
import com.sys.mype.sysce.pe.dto.request.OrderTypeRequestDTO;
import com.sys.mype.sysce.pe.errorhandler.SysceEntityNotFoundException;
import com.sys.mype.sysce.pe.model.BOrderType;
import com.sys.mype.sysce.pe.repository.OrderTypeRepository;
import com.sys.mype.sysce.pe.service.OrderTypeService;
import com.sys.mype.sysce.pe.util.SysceResources;
import com.sys.mype.sysce.pe.util.Util;

@Service
public class OrderTypeServiceImpl implements OrderTypeService{

	final OrderTypeRepository orderTypeRespository;
	final Util util;

	public OrderTypeServiceImpl(OrderTypeRepository orderTypeRespository,Util util) {
		this.orderTypeRespository = orderTypeRespository;
		this.util=util;
	}

	@Override
	public HrefEntityDTO save(OrderTypeRequestDTO dto) {
		BOrderType bOrderType=new BOrderType();
		bOrderType.setOrderTypeDescription(dto.getDescription());
		bOrderType.setOrderTypeStatus(SysceConstant.STATE_ACTIVE);
		return Util.createHrefFromResource(this.orderTypeRespository.save(bOrderType).getOrderTypeId(), SysceResources.ORDERTYPE);
	}

	@Override
	public HrefEntityDTO update(OrderTypeRequestDTO dto, int id) {
		BOrderType bOrderType=this.orderTypeRespository.findByOrderTypeIdAndOrderTypeStatus(id, SysceConstant.STATE_ACTIVE).orElseThrow(()->new SysceEntityNotFoundException("not found ordertype"));
		bOrderType.setOrderTypeDescription(dto.getDescription());
		return Util.createHrefFromResource(this.orderTypeRespository.save(bOrderType).getOrderTypeId(), SysceResources.ORDERTYPE);
	}

	@Override
	public HrefEntityDTO delete(int id) {
		BOrderType bOrderType=this.orderTypeRespository.findByOrderTypeIdAndOrderTypeStatus(id, SysceConstant.STATE_ACTIVE).orElseThrow(()->new SysceEntityNotFoundException("not found ordertype"));
		bOrderType.setOrderTypeStatus(SysceConstant.STATE_INACTIVE);
		return Util.createHrefFromResource(this.orderTypeRespository.save(bOrderType).getOrderTypeId(), SysceResources.ORDERTYPE);
	}

	@Override
	public List<GenericDTO> findAll() {
		return this.orderTypeRespository.findAll().stream().map((bean)->new GenericDTO(bean.getOrderTypeId(),bean.getOrderTypeDescription()))
				.collect(Collectors.toList());
	}

	@Override
	public GenericDTO findById(int id) {
		BOrderType bOrderType=this.orderTypeRespository.findByOrderTypeIdAndOrderTypeStatus(id, SysceConstant.STATE_ACTIVE).orElseThrow(()->new SysceEntityNotFoundException("not found ordertype"));
		GenericDTO dto=new GenericDTO();
		dto.setId(bOrderType.getOrderTypeId());
		dto.setDescription(bOrderType.getOrderTypeDescription());
		return dto;
	}
	
	
}
