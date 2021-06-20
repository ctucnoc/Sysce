package com.sys.mype.sysce.pe.service;

import com.sys.mype.sysce.pe.dto.HrefEntityDTO;
import com.sys.mype.sysce.pe.dto.request.KindProductRequestDTO;

public interface KindProductService {

	public HrefEntityDTO save(KindProductRequestDTO dto);
}
