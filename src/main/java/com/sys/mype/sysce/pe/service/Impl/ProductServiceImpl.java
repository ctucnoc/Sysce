package com.sys.mype.sysce.pe.service.Impl;

import com.sys.mype.sysce.pe.dto.ProductDTO;
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

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> findAll() {

        //List<ProductDTO> dtoList = new ArrayList<>();


        //Iterable<BProduct> products = productRepository.findAll();


        return ((List<BProduct>) productRepository.findAll()).stream().map((bean)->
            new ProductDTO(
                        bean.getProductId(),
                        bean.getProductName(),
                        bean.getProductNameSummary(),
                        bean.getProductKit(),
                        bean.getProductGeneric(),
                        bean.getProductBatch(),
                        bean.getProductExpirationDate(),
                        bean.getProductRefrigeration(),
                        bean.getProductStatus(),
                        bean.getBSubCategory().getSubCategoryId())).collect(Collectors.toList());

//        for (BProduct bProduct : products){
//
//            ProductDTO productDTO = new ProductDTO();
//
//            productDTO.setProductId(bProduct.getProductId());
//            productDTO.setProductName(bProduct.getProductName());
//            productDTO.setProductNameSummary(bProduct.getProductNameSummary());
//            productDTO.setProductKit(bProduct.getProductKit());
//            productDTO.setProductGeneric(bProduct.getProductGeneric());
//            productDTO.setProductBatch(bProduct.getProductBatch());
//            productDTO.setProductExpirationDate(bProduct.getProductExpirationDate());
//            productDTO.setProductRefrigeration(bProduct.getProductRefrigeration());
//            productDTO.setProductStatus(bProduct.getProductStatus());
//            productDTO.setSubCategoryId(bProduct.getBSubCategory().getSubCategoryId());
//            dtoList.add(productDTO);
//
//        }
//
//
//        return dtoList;
    }

    @Override
    public void save(ProductDTO productDTO) {

        if (!Util.validateEmptyField(productDTO.getProductName())){
            System.out.println("llaalalalal");
            throw new SysceGenericClientException("Por favor, ingrese un producto", HttpStatus.BAD_REQUEST);
        }
        BProduct bProduct = new BProduct();
        bProduct.setProductId(productDTO.getProductId());
        bProduct.setProductName(productDTO.getProductName());
        bProduct.setProductNameSummary(productDTO.getProductNameSummary());
        bProduct.setProductKit(productDTO.getProductKit());
        bProduct.setProductGeneric(productDTO.getProductGeneric());
        bProduct.setProductBatch(productDTO.getProductBatch());
        bProduct.setProductExpirationDate(productDTO.getProductExpirationDate());
        bProduct.setProductRefrigeration(productDTO.getProductRefrigeration());
        bProduct.setProductStatus(productDTO.getProductStatus());

        BSubCategory bSubCategory = new BSubCategory();
        bSubCategory.setSubCategoryId(productDTO.getSubCategoryId());

        bProduct.setBSubCategory(bSubCategory);

        this.productRepository.save(bProduct);

    }

    @Override
    public List<ProductDTO> findByProductName() {
        return null;
    }

    @Override
    public ProductDTO findById(String productId) {
        return null;
    }
}
