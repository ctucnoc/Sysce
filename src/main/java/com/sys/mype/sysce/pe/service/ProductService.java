package com.sys.mype.sysce.pe.service;

import com.sys.mype.sysce.pe.dto.ProductDTO;
import com.sys.mype.sysce.pe.model.BProduct;

import java.util.List;

public interface ProductService {

    public List<ProductDTO> findAll();
    public void save(ProductDTO productDTO);

    public List<ProductDTO> findByProductName(String productName);

    public ProductDTO findByProductId(String productId);

}
