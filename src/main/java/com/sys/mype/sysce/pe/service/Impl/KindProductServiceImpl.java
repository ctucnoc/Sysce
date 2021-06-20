package com.sys.mype.sysce.pe.service.Impl;

import javax.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.HrefEntityDTO;
import com.sys.mype.sysce.pe.dto.request.KindProductRequestDTO;
import com.sys.mype.sysce.pe.errorhandler.SysceEntityNotFoundException;
import com.sys.mype.sysce.pe.errorhandler.SysceGenericClientException;
import com.sys.mype.sysce.pe.model.BKindProduct;
import com.sys.mype.sysce.pe.model.BKindSale;
import com.sys.mype.sysce.pe.model.BProduct;
import com.sys.mype.sysce.pe.repository.KindProductRepository;
import com.sys.mype.sysce.pe.repository.KindSaleRepository;
import com.sys.mype.sysce.pe.repository.ProductRepository;
import com.sys.mype.sysce.pe.service.KindProductService;
import com.sys.mype.sysce.pe.util.SysceResources;
import com.sys.mype.sysce.pe.util.Util;

@Service
@Transactional
public class KindProductServiceImpl implements KindProductService{

	final KindProductRepository kindProductRepository;
	final ProductRepository productRepository;
	final KindSaleRepository kindSaleRepository;

	public KindProductServiceImpl(KindProductRepository kindProductRepository,ProductRepository productRepository,KindSaleRepository kindSaleRepository) {
		this.kindProductRepository = kindProductRepository;
		this.kindSaleRepository=kindSaleRepository;
		this.productRepository=productRepository;
	}

	@Override
	public HrefEntityDTO save(KindProductRequestDTO dto) {
		BProduct bProduct=this.productRepository.findByProductIdAndProductStatus(dto.getProductId(),SysceConstant.STATE_ACTIVE).orElseThrow(()->new SysceEntityNotFoundException("not found product"));
		BKindSale bKindSale=this.kindSaleRepository.findByKindSaleIdAndKindSaleStatus(dto.getKindSaleId(), SysceConstant.STATE_ACTIVE).orElseThrow(()-> new SysceEntityNotFoundException("not found kindsale"));
		if(this.kindProductRepository.existsByProductIdAndKindSaleId(dto.getProductId(), dto.getKindSaleId()))
			throw new SysceGenericClientException("exists kind product", HttpStatus.BAD_REQUEST);
		BKindProduct bKindProduct=new BKindProduct();
		bKindProduct.setBKindSale(bKindSale);
		bKindProduct.setBProduct(bProduct);
		bKindProduct.setKindProductPrice(dto.getPrecio());
		bKindProduct.setKindProductStatus(SysceConstant.STATE_ACTIVE);
		bKindProduct.setKindProductCantOrders(SysceConstant.CANT_ORDERS);
		return Util.createHrefFromResource(this.kindProductRepository.save(bKindProduct).getKindProductId(), SysceResources.KINDPRODUCT);
	}
	

	
}
