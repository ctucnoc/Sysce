package com.sys.mype.sysce.pe.service.Impl;

import com.sys.mype.sysce.pe.dto.ProductDTO;
import com.sys.mype.sysce.pe.model.BProduct;
import com.sys.mype.sysce.pe.repository.ProductRepository;
import com.sys.mype.sysce.pe.service.ProductService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> findAll() {

        List<ProductDTO> dtoList = new ArrayList<>();


        Iterable<BProduct> products = productRepository.findAll();

        for (BProduct bProduct : products){
            ProductDTO productDTO = new ProductDTO();
            productDTO.setProductId(bProduct.getProductId());
            productDTO.setProductName(bProduct.getProductName());
            productDTO.setProductNameSummary(bProduct.getProductNameSummary());
            productDTO.setProductKit(bProduct.getProductKit());
            productDTO.setProductGeneric(bProduct.getProductGeneric());
            productDTO.setProductBatch(bProduct.getProductBatch());
            productDTO.setProductExpirationDate(bProduct.getProductExpirationDate());
            productDTO.setProductRefrigeration(bProduct.getProductRefrigeration());
            productDTO.setProductStatus(bProduct.getProductStatus());
            productDTO.setSubCategoryId(bProduct.getBSubCategory().getSubCategoryId());
            dtoList.add(productDTO);

        }


        return dtoList;
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        return null;
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
