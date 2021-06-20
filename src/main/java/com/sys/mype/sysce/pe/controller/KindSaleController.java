package com.sys.mype.sysce.pe.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.request.KindSaleRequestDTO;
import com.sys.mype.sysce.pe.service.KindSaleService;
import com.sys.mype.sysce.pe.util.CRUD;

@RestController
@RequestMapping(SysceConstant.RESOURCE_KINDSALES)
@CrossOrigin(SysceConstant.PATH_FROTEND_SYSCE)
public class KindSaleController extends GenericController {

	final KindSaleService kindSaleService;

	public KindSaleController(KindSaleService kindSaleService) {
		this.kindSaleService = kindSaleService;
	}

	@PostMapping(SysceConstant.RESOURCE_KINDSALES_KINDSALE)
	public ResponseEntity<?> add(@Valid @RequestBody KindSaleRequestDTO dto) {
		return super.ok(this.kindSaleService.save(dto), CRUD.REGISTER);
	}

	@GetMapping(SysceConstant.RESOURCE_KINDSALES_KINDSALE)
	public ResponseEntity<?> findByDescription(@RequestParam String key_word) {
		return super.ok(this.kindSaleService.findByDescription(key_word), CRUD.FIND);
	}

	@GetMapping(SysceConstant.RESOURCE_KINDSALES_KINDSALE + "/{id}")
	public ResponseEntity<?> findById(@PathVariable int id) {
		return super.ok(this.kindSaleService.findById(id), CRUD.FIND);
	}

	@PutMapping(SysceConstant.RESOURCE_KINDSALES_KINDSALE + "/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody KindSaleRequestDTO dto, @PathVariable int id) {
		return super.ok(this.kindSaleService.update(dto, id), CRUD.UPDATE);
	}

	@PatchMapping(SysceConstant.RESOURCE_KINDSALES_KINDSALE + "/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		return super.ok(this.kindSaleService.delete(id), CRUD.DELETE);
	}

}
