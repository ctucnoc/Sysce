package com.sys.mype.sysce.pe.service;

import java.util.List;
import com.sys.mype.sysce.pe.dto.SubsidiaryInitDTO;

public interface UserSubsidiaryService {
	public List<SubsidiaryInitDTO> findByUserSubsidiary(String userId,String ruc);
}
