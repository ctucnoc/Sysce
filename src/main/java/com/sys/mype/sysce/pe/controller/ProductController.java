package com.sys.mype.sysce.pe.controller;

import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.MessageDTO;
import com.sys.mype.sysce.pe.dto.ProductDTO;
import com.sys.mype.sysce.pe.model.BProduct;
import com.sys.mype.sysce.pe.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(SysceConstant.PATH_SYSCE_APP_PRODUCT)
@CrossOrigin(SysceConstant.PATH_FROTEND_SYSCE)
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/findall")
    public ResponseEntity<?> findAll(){

        /**
         * Primera forma
         * Utilizando HashMap
         */
        //Map<String, Object> response = new HashMap<>();
        //response.put("listProducts", productService.findAll());
        //return new ResponseEntity<>(response, HttpStatus.OK);

        /**
         * Segunda forma
         * Similar al primero pero sin HashMap *ctc
         */
        return new ResponseEntity<>(this.productService.findAll(), HttpStatus.CREATED);

        /**
         * Tercera forma
         */
        //return ResponseEntity.status(HttpStatus.OK).body(productService.findAll());


    }

    @PostMapping("/add")
    public ResponseEntity<?> save(@RequestBody ProductDTO productDTO){
        this.productService.save(productDTO);
        return new ResponseEntity<>(new MessageDTO("Producto guardado"), HttpStatus.CREATED);
    }

    @GetMapping("/findByProductName/{productName}")
    public List<ProductDTO> findByProductName(@PathVariable String productName){
        return this.productService.findByProductName(productName);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody ProductDTO productDTO){

        ProductDTO dProductDTO = this.productService.findByProductId(productDTO.getProductId());

        dProductDTO.setProductKit(productDTO.getProductKit());
        dProductDTO.setProductBatch(productDTO.getProductBatch());
        dProductDTO.setProductGeneric(productDTO.getProductGeneric());
        dProductDTO.setProductName(productDTO.getProductName());
        dProductDTO.setProductStatus(productDTO.getProductStatus());
        dProductDTO.setProductExpirationDate(productDTO.getProductExpirationDate());
        dProductDTO.setProductRefrigeration(productDTO.getProductRefrigeration());
        dProductDTO.setProductNameSummary(productDTO.getProductNameSummary());

        this.productService.save(dProductDTO);

        return new ResponseEntity<>(new MessageDTO("Ep producto fue actualizado correctamente"), HttpStatus.CREATED);

    }

}
