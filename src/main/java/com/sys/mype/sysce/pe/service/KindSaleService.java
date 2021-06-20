package com.sys.mype.sysce.pe.service;

import java.util.List;
import com.sys.mype.sysce.pe.dto.HrefEntityDTO;
import com.sys.mype.sysce.pe.dto.KindSaleDTO;
import com.sys.mype.sysce.pe.dto.request.KindSaleRequestDTO;

public interface KindSaleService {
	public HrefEntityDTO save(KindSaleRequestDTO dto);
	public List<KindSaleDTO> findByDescription(String description);
	public KindSaleDTO findById(int id);
	public HrefEntityDTO update(KindSaleRequestDTO dto,int id);
	public HrefEntityDTO delete(int id);
}
