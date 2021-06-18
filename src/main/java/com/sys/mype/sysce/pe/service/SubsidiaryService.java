package com.sys.mype.sysce.pe.service;

import com.sys.mype.sysce.pe.dto.HrefEntityDTO;
import com.sys.mype.sysce.pe.dto.SubsidiaryDTO;

import java.util.List;

public interface SubsidiaryService {
	public HrefEntityDTO save(SubsidiaryDTO dto);
	public HrefEntityDTO update(SubsidiaryDTO dto,int id);
	public HrefEntityDTO delete(int id);
	public List<SubsidiaryDTO> findAllByEnterpriseId(int id);
}
