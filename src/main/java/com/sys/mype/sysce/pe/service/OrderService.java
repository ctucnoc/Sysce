package com.sys.mype.sysce.pe.service;

import com.sys.mype.sysce.pe.dto.HrefEntityDTO;
import com.sys.mype.sysce.pe.dto.OrderDTO;
import com.sys.mype.sysce.pe.dto.request.OrderRequestDTO;

public interface OrderService {
	public HrefEntityDTO save(OrderRequestDTO dto);
	public OrderDTO findById(String id);
}
