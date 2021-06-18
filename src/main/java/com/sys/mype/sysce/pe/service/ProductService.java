package com.sys.mype.sysce.pe.service;

import com.sys.mype.sysce.pe.dto.HrefEntityDTO;
import com.sys.mype.sysce.pe.dto.ProductDTO;
import com.sys.mype.sysce.pe.dto.request.ProductRequestDTO;

import java.util.List;

public interface ProductService {

    public HrefEntityDTO save(ProductRequestDTO productDTO);
    
    public HrefEntityDTO update(ProductRequestDTO productDTO,String id);
    
    public HrefEntityDTO delete(String id);

    public List<ProductDTO> findByProductName(String productName);

    public ProductDTO findByProductId(String productId);

}
