package com.sys.mype.sysce.pe.controller;

import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.request.ProductRequestDTO;
import com.sys.mype.sysce.pe.service.ProductService;
import com.sys.mype.sysce.pe.util.CRUD;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(SysceConstant.RESOURCE_PRODUCTS)
@CrossOrigin(SysceConstant.PATH_FROTEND_SYSCE)
public class ProductController extends GenericController{

	final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping(SysceConstant.RESOURCE_PRODUCTS_PRODUCT)
	public ResponseEntity<?> save(@RequestBody ProductRequestDTO productDTO) {
		return super.ok(this.productService.save(productDTO), CRUD.REGISTER);
	}

	@GetMapping(SysceConstant.RESOURCE_PRODUCTS_PRODUCT)
	public ResponseEntity<?> findByProductName(@RequestParam String name) {
		return super.ok(this.productService.findByProductName(name), CRUD.FIND);
	}

	@PutMapping(SysceConstant.RESOURCE_PRODUCTS_PRODUCT+"/{id}")
	public ResponseEntity<?> update(@RequestBody ProductRequestDTO productDTO,@PathVariable String id) {
		return super.ok(this.productService.update(productDTO, id), CRUD.UPDATE);
	}
	
	@PatchMapping(SysceConstant.RESOURCE_PRODUCTS_PRODUCT+"/{id}")
	public ResponseEntity<?> delete(@PathVariable String id){
		return super.ok(this.productService.delete(id), CRUD.DELETE);
	}

}
