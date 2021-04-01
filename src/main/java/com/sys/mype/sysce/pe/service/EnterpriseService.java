package com.sys.mype.sysce.pe.service;

import com.sys.mype.sysce.pe.dto.EnterpriseDTO;

import java.util.List;

public interface EnterpriseService {
    public void save(EnterpriseDTO dto);
    public List<EnterpriseDTO> findByName(String name);
    public EnterpriseDTO findById(int id);
}
