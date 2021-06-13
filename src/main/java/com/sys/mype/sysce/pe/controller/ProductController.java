package com.sys.mype.sysce.pe.controller;

import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.MessageDTO;
import com.sys.mype.sysce.pe.dto.ProductDTO;
import com.sys.mype.sysce.pe.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(SysceConstant.RESOURCE_PRODUCTS)
@CrossOrigin(SysceConstant.PATH_FROTEND_SYSCE)
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/findall")
	public ResponseEntity<?> findAll() {
		return null;
	}

	@PostMapping("/add")
	public ResponseEntity<?> save(@RequestBody ProductDTO productDTO) {
		this.productService.save(productDTO);
		return new ResponseEntity<>(new MessageDTO("Producto guardado"), HttpStatus.CREATED);
	}

	@GetMapping("/findByProductName/{productName}")
	public List<ProductDTO> findByProductName(@PathVariable String productName) {
		return this.productService.findByProductName(productName);
	}

	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody ProductDTO productDTO) {

		ProductDTO dProductDTO = this.productService.findByProductId(productDTO.getId());

		dProductDTO.setKit(productDTO.getKit());
		dProductDTO.setBatch(productDTO.getBatch());
		dProductDTO.setGeneric(productDTO.getGeneric());
		dProductDTO.setName(productDTO.getName());
		dProductDTO.setStatus(productDTO.getStatus());
		dProductDTO.setExpDate(productDTO.getExpDate());
		dProductDTO.setRefrigeration(productDTO.getRefrigeration());
		dProductDTO.setSummary(productDTO.getSummary());

		this.productService.save(dProductDTO);

		return new ResponseEntity<>(new MessageDTO("Fue producto fue actualizado correctamente"), HttpStatus.CREATED);

	}

}
