package com.sys.mype.sysce.pe.service.Impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.HrefEntityDTO;
import com.sys.mype.sysce.pe.dto.KindSaleDTO;
import com.sys.mype.sysce.pe.dto.request.KindSaleRequestDTO;
import com.sys.mype.sysce.pe.errorhandler.SysceEntityNotFoundException;
import com.sys.mype.sysce.pe.model.BKindSale;
import com.sys.mype.sysce.pe.repository.KindSaleRepository;
import com.sys.mype.sysce.pe.service.KindSaleService;
import com.sys.mype.sysce.pe.util.SysceResources;
import com.sys.mype.sysce.pe.util.Util;

@Service
public class KindSaleServiceImpl implements KindSaleService{

	final KindSaleRepository kindSaleRepository;

	public KindSaleServiceImpl(KindSaleRepository kindSaleRepository) {
		this.kindSaleRepository = kindSaleRepository;
	}

	@Override
	public HrefEntityDTO save(KindSaleRequestDTO dto) {
		BKindSale bKindSale=new BKindSale();
		bKindSale.setKindSaleDescription(dto.getDescription());
		bKindSale.setKindSaleStatus(SysceConstant.STATE_ACTIVE);
		return Util.createHrefFromResource(this.kindSaleRepository.save(bKindSale).getKindSaleId(), SysceResources.KINDSALE);
	}

	@Override
	public List<KindSaleDTO> findByDescription(String description) {
		return this.kindSaleRepository.findByKindSaleDescriptionLikeIgnoreCaseAndKindSaleStatus("%"+description+"%", SysceConstant.STATE_ACTIVE)
				.stream()
				.map((bean)->new KindSaleDTO(bean.getKindSaleId(), bean.getKindSaleDescription()))
				.collect(Collectors.toList());
	}

	@Override
	public KindSaleDTO findById(int id) {
		BKindSale bKindSale=this.kindSaleRepository.findByKindSaleIdAndKindSaleStatus(id, SysceConstant.STATE_ACTIVE).orElseThrow(()-> new SysceEntityNotFoundException("not found kindsale"));
		KindSaleDTO dto=new KindSaleDTO();
		dto.setId(bKindSale.getKindSaleId());
		dto.setDescription(bKindSale.getKindSaleDescription());
		return dto;
	}

	@Override
	public HrefEntityDTO update(KindSaleRequestDTO dto, int id) {
		BKindSale bKindSale=this.kindSaleRepository.findByKindSaleIdAndKindSaleStatus(id, SysceConstant.STATE_ACTIVE).orElseThrow(()-> new SysceEntityNotFoundException("not found kindsale"));
		bKindSale.setKindSaleDescription(dto.getDescription());
		return Util.createHrefFromResource(this.kindSaleRepository.save(bKindSale).getKindSaleId(), SysceResources.KINDSALE);
	}

	@Override
	public HrefEntityDTO delete(int id) {
		BKindSale bKindSale=this.kindSaleRepository.findByKindSaleIdAndKindSaleStatus(id, SysceConstant.STATE_ACTIVE).orElseThrow(()-> new SysceEntityNotFoundException("not found kindsale"));
		bKindSale.setKindSaleDescription(SysceConstant.STATE_ACTIVE);
		return Util.createHrefFromResource(this.kindSaleRepository.save(bKindSale).getKindSaleId(), SysceResources.KINDSALE);
	}
	
	
}
