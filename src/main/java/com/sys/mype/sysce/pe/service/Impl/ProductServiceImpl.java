package com.sys.mype.sysce.pe.service.Impl;

import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.HrefEntityDTO;
import com.sys.mype.sysce.pe.dto.ProductDTO;
import com.sys.mype.sysce.pe.dto.request.ProductRequestDTO;
import com.sys.mype.sysce.pe.errorhandler.SysceEntityNotFoundException;
import com.sys.mype.sysce.pe.errorhandler.SysceGenericClientException;
import com.sys.mype.sysce.pe.errorhandler.SysceGenericServerException;
import com.sys.mype.sysce.pe.model.BProduct;
import com.sys.mype.sysce.pe.model.BSubCategory;
import com.sys.mype.sysce.pe.repository.ProductRepository;
import com.sys.mype.sysce.pe.repository.SubCategoryRepository;
import com.sys.mype.sysce.pe.service.ProductService;
import com.sys.mype.sysce.pe.util.SysceResources;
import com.sys.mype.sysce.pe.util.Util;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    final ProductRepository productRepository;
    final SubCategoryRepository subCategoryRepository;

    public ProductServiceImpl(ProductRepository productRepository,SubCategoryRepository subCategoryRepository) {
        this.productRepository = productRepository;
        this.subCategoryRepository=subCategoryRepository;
    }

    @Override
    public HrefEntityDTO save(ProductRequestDTO productDTO) {
    	String generatedId=this.productRepository.GeneratedProductId(productDTO.getSubCategoryId()).orElseThrow(()-> new SysceGenericServerException("error generating id"));
    	BSubCategory bSubCategory = this.subCategoryRepository.findById(productDTO.getSubCategoryId()).orElseThrow(()->new SysceEntityNotFoundException("not found subcategory"));
        BProduct bProduct = new BProduct();
        bProduct.setProductId(generatedId);
        bProduct.setProductName(productDTO.getName());
        bProduct.setProductNameSummary(productDTO.getSummary());
        bProduct.setProductKit(productDTO.getKit());
        bProduct.setProductGeneric(productDTO.getGeneric());
        bProduct.setProductBatch(productDTO.getBatch());
        bProduct.setProductExpirationDate(productDTO.getExpDate());
        bProduct.setProductRefrigeration(productDTO.getRefrigeration());
        bProduct.setProductStatus(SysceConstant.STATE_ACTIVE);      
        bProduct.setBSubCategory(bSubCategory);
        return Util.createHrefFromResource(this.productRepository.save(bProduct).getProductId(), SysceResources.PRODUCT);
    }

    @Override
    public List<ProductDTO> findByProductName(String productName) {
        //return this.productRepository.findByProductName(productName, SysceConstant.STATE_ACTIVE)
        //return this.productRepository.findByProductNameContainingIgnoreCaseAndProductStatus(productName, SysceConstant.STATE_ACTIVE)
        return this.productRepository.findByProductNameLikeIgnoreCaseAndProductStatus("%"+productName+"%", SysceConstant.STATE_ACTIVE)
                .stream()
                .map(bProduct ->
                        new ProductDTO(
                                bProduct.getProductId(),
                                bProduct.getProductName(),
                                bProduct.getProductNameSummary(),
                                bProduct.getProductKit(),
                                bProduct.getProductGeneric(),
                                bProduct.getProductBatch(),
                                bProduct.getProductExpirationDate(),
                                bProduct.getProductRefrigeration(),
                                bProduct.getBSubCategory().getSubCategoryId()))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO findByProductId(String productId) {
        BProduct bProduct = this.productRepository.findById(productId)
                .orElseThrow(()->new SysceEntityNotFoundException(String.format("Producto con %s no encontrado",productId)));
        return new ProductDTO(
                bProduct.getProductId(),
                bProduct.getProductName(),
                bProduct.getProductNameSummary(),
                bProduct.getProductKit(),
                bProduct.getProductGeneric(),
                bProduct.getProductBatch(),
                bProduct.getProductExpirationDate(),
                bProduct.getProductRefrigeration(),
                bProduct.getBSubCategory().getSubCategoryId()
        );
    }

	@Override
	public HrefEntityDTO update(ProductRequestDTO productDTO, String id) {
		BSubCategory bSubCategory=this.subCategoryRepository.findById(productDTO.getSubCategoryId()).orElseThrow(()->new SysceEntityNotFoundException("not found subcategory"));
		BProduct bProduct=this.productRepository.findById(id).orElseThrow(()->new SysceEntityNotFoundException("not found product"));
		bProduct.setProductBatch(productDTO.getBatch());
		bProduct.setProductExpirationDate(productDTO.getExpDate());
		bProduct.setProductGeneric(productDTO.getGeneric());
		bProduct.setProductKit(bProduct.getProductKit());
		bProduct.setProductName(productDTO.getName());
		bProduct.setProductNameSummary(productDTO.getSummary());
		bProduct.setProductRefrigeration(productDTO.getRefrigeration());
		bProduct.setBSubCategory(bSubCategory);
		this.productRepository.save(bProduct);
		return Util.createHrefFromResource(bProduct.getProductId(), SysceResources.PRODUCT);
	}

	@Override
	public HrefEntityDTO delete(String id) {
		BProduct bProduct=this.productRepository.findById(id).orElseThrow(()->new SysceEntityNotFoundException("not found product"));
		bProduct.setProductStatus(SysceConstant.STATE_INACTIVE);
		this.productRepository.save(bProduct);
		return Util.createHrefFromResource(bProduct.getProductId(), SysceResources.PRODUCT);
	}

}
