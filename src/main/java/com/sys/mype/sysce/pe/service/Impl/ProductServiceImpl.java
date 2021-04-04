package com.sys.mype.sysce.pe.service.Impl;

import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.ProductDTO;
import com.sys.mype.sysce.pe.errorhandler.SysceEntityNotFoundException;
import com.sys.mype.sysce.pe.errorhandler.SysceGenericClientException;
import com.sys.mype.sysce.pe.model.BProduct;
import com.sys.mype.sysce.pe.model.BSubCategory;
import com.sys.mype.sysce.pe.repository.ProductRepository;
import com.sys.mype.sysce.pe.service.ProductService;
import com.sys.mype.sysce.pe.util.Util;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> findAll() {

        return ((List<BProduct>) productRepository.findAll()).stream().map((bProduct)->
            new ProductDTO(
                        bProduct.getProductId(),
                        bProduct.getProductName(),
                        bProduct.getProductNameSummary(),
                        bProduct.getProductKit(),
                        bProduct.getProductGeneric(),
                        bProduct.getProductBatch(),
                        bProduct.getProductExpirationDate(),
                        bProduct.getProductRefrigeration(),
                        bProduct.getProductStatus(),
                        bProduct.getBSubCategory().getSubCategoryId())).collect(Collectors.toList());
    }

    @Override
    public void save(ProductDTO productDTO) {

        if (!Util.validateEmptyField(productDTO.getName())){
            throw new SysceGenericClientException("Por favor, ingrese un producto", HttpStatus.BAD_REQUEST);
        }

        BProduct bProduct = new BProduct();
        bProduct.setProductId(productDTO.getId());
        bProduct.setProductName(productDTO.getName());
        bProduct.setProductNameSummary(productDTO.getSummary());
        bProduct.setProductKit(productDTO.getKit());
        bProduct.setProductGeneric(productDTO.getGeneric());
        bProduct.setProductBatch(productDTO.getBatch());
        bProduct.setProductExpirationDate(productDTO.getExpDate());
        bProduct.setProductRefrigeration(productDTO.getRefrigeration());
        bProduct.setProductStatus(productDTO.getStatus());

        BSubCategory bSubCategory = new BSubCategory();
        bSubCategory.setSubCategoryId(productDTO.getSubCategoryId());

        bProduct.setBSubCategory(bSubCategory);

        this.productRepository.save(bProduct);

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
                                bProduct.getProductStatus(),
                                bProduct.getBSubCategory().getSubCategoryId())).collect(Collectors.toList());
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
                bProduct.getProductStatus(),
                bProduct.getBSubCategory().getSubCategoryId()
        );
    }


}
