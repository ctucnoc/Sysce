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
import com.sys.mype.sysce.pe.dto.request.ConsumerRequestDTO;
import com.sys.mype.sysce.pe.service.ConsumerService;
import com.sys.mype.sysce.pe.util.CRUD;

@RestController
@RequestMapping(SysceConstant.RESOURCE_CONSUMERS)
@CrossOrigin(SysceConstant.PATH_FROTEND_SYSCE)
public class ConsumerController extends GenericController {

	final ConsumerService consumerService;

	public ConsumerController(ConsumerService consumerService) {
		this.consumerService = consumerService;
	}

	@PostMapping(SysceConstant.RESOURCE_CONSUMERS_CONSUMER)
	public ResponseEntity<?> add(@Valid @RequestBody ConsumerRequestDTO dto) {
		return super.ok(this.consumerService.save(dto), CRUD.REGISTER);
	}

	@PutMapping(SysceConstant.RESOURCE_CONSUMERS_CONSUMER + "/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody ConsumerRequestDTO dto, @PathVariable String id) {
		return super.ok(this.consumerService.update(dto, id), CRUD.UPDATE);
	}

	@PatchMapping(SysceConstant.RESOURCE_CONSUMERS_CONSUMER + "/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
		return super.ok(this.consumerService.delete(id), CRUD.DELETE);
	}

	@GetMapping(SysceConstant.RESOURCE_CONSUMERS_CONSUMER + "/{id}")
	public ResponseEntity<?> findById(@PathVariable String id) {
		return super.ok(this.consumerService.findById(id), CRUD.FIND);
	}

	@GetMapping(SysceConstant.RESOURCE_CONSUMERS_CONSUMER)
	public ResponseEntity<?> findByKeyWord(@RequestParam String key_word) {
		return super.ok(this.consumerService.findByDescription(key_word), CRUD.FIND);
	}

}
