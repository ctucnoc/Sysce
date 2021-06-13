package com.sys.mype.sysce.pe.service;

import com.sys.mype.sysce.pe.dto.EnterpriseDTO;
import com.sys.mype.sysce.pe.dto.HrefEntityDTO;
import com.sys.mype.sysce.pe.dto.request.EnterpriseRequestDTO;

import java.util.List;

public interface EnterpriseService {
    public HrefEntityDTO save(EnterpriseRequestDTO dto);
    public HrefEntityDTO update(int id,EnterpriseRequestDTO dto);
    public List<EnterpriseDTO> findByName(String name);
    public EnterpriseDTO findById(int id);
}
