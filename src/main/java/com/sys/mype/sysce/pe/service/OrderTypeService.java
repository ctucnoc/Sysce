package com.sys.mype.sysce.pe.service;

import java.util.List;

import com.sys.mype.sysce.pe.dto.GenericDTO;
import com.sys.mype.sysce.pe.dto.HrefEntityDTO;
import com.sys.mype.sysce.pe.dto.request.OrderTypeRequestDTO;

public interface OrderTypeService {
	public HrefEntityDTO save(OrderTypeRequestDTO dto);
	public HrefEntityDTO update(OrderTypeRequestDTO dto,int id);
	public HrefEntityDTO delete(int id);
	public List<GenericDTO> findAll();
	public GenericDTO findById(int id);

}
