package com.sys.mype.sysce.pe.service;

import java.util.List;
import com.sys.mype.sysce.pe.dto.GenericDTO;
import com.sys.mype.sysce.pe.dto.HrefEntityDTO;
import com.sys.mype.sysce.pe.dto.request.OrderStatusRequestDTO;

public interface OrderStatusService {
	public HrefEntityDTO save(OrderStatusRequestDTO dto);

	public HrefEntityDTO update(OrderStatusRequestDTO dto, int id);

	public GenericDTO findById(int id);

	public List<GenericDTO> findAll();
}
