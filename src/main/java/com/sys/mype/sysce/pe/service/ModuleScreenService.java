package com.sys.mype.sysce.pe.service;

import java.util.List;
import com.sys.mype.sysce.pe.dto.ModuleScreenDTO;
import com.sys.mype.sysce.pe.dto.NavItemDTO;

public interface ModuleScreenService {
    public void save(ModuleScreenDTO dto);
    public List<NavItemDTO> findByModuleScreenUser(String userId);
}
