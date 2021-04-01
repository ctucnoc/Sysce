package com.sys.mype.sysce.pe.service;

import com.sys.mype.sysce.pe.dto.SubsidiaryDTO;

import java.util.List;

public interface SubsidiaryService {
    public void save(SubsidiaryDTO dto);
    public List<SubsidiaryDTO> findAllByEnterpriseId(int id);
}
