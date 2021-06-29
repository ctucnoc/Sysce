package com.sys.mype.sysce.pe.service;

import java.util.List;
import com.sys.mype.sysce.pe.dto.ConsumerDTO;
import com.sys.mype.sysce.pe.dto.HrefEntityDTO;
import com.sys.mype.sysce.pe.dto.request.ConsumerRequestDTO;

public interface ConsumerService{
	public HrefEntityDTO save(ConsumerRequestDTO dto);
	public HrefEntityDTO update(ConsumerRequestDTO dto,String id);
	public HrefEntityDTO delete(String id);
	public ConsumerDTO findById(String id);
	public List<ConsumerDTO> findByDescription(String key_word);
}
