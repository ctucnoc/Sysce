package com.sys.mype.sysce.pe.controller;

import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.request.KindProductRequestDTO;
import com.sys.mype.sysce.pe.service.KindProductService;
import com.sys.mype.sysce.pe.util.CRUD;

@RestController
@RequestMapping(SysceConstant.RESOURCE_KINDPRODUCTS)
@CrossOrigin(SysceConstant.PATH_FROTEND_SYSCE)
public class KindProductController extends GenericController {

	final KindProductService kindProductService;

	public KindProductController(KindProductService kindProductService) {
		this.kindProductService = kindProductService;
	}

	@PostMapping(SysceConstant.RESOURCE_KINDPRODUCTS_KINDPRODUCT)
	public ResponseEntity<?> add(@Valid @RequestBody KindProductRequestDTO dto) {
		return super.ok(this.kindProductService.save(dto), CRUD.REGISTER);
	}

}
