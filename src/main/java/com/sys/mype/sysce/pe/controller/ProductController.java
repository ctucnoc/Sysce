package com.sys.mype.sysce.pe.controller;

import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.MessageDTO;
import com.sys.mype.sysce.pe.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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
        return new ResponseEntity<>(productService.findAll(), HttpStatus.CREATED);

        /**
         * Tercera forma
         */
        //return ResponseEntity.status(HttpStatus.OK).body(productService.findAll());


    }

}
