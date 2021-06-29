package com.sys.mype.sysce.pe.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.request.OrderStatusRequestDTO;
import com.sys.mype.sysce.pe.service.OrderStatusService;
import com.sys.mype.sysce.pe.util.CRUD;

@RestController
@RequestMapping(SysceConstant.RESOURCE_ORDERSTATUSS)
@CrossOrigin(SysceConstant.PATH_FROTEND_SYSCE)
public class OrderStatusController extends GenericController{
	
	final OrderStatusService orderStatusService;

	public OrderStatusController(OrderStatusService orderStatusService) {
		this.orderStatusService = orderStatusService;
	}
	
	@PostMapping(SysceConstant.RESOURCE_ORDERSTATUSS_ORDERSTATUS)
	public ResponseEntity<?> save(@Valid @RequestBody OrderStatusRequestDTO dto) {
		return super.ok(this.orderStatusService.save(dto), CRUD.REGISTER);
	}

	@GetMapping(SysceConstant.RESOURCE_ORDERSTATUSS_ORDERSTATUS + "/{id}")
	public ResponseEntity<?> save(@PathVariable int id) {
		return super.ok(this.orderStatusService.findById(id), CRUD.FIND);
	}

	@PutMapping(SysceConstant.RESOURCE_ORDERSTATUSS_ORDERSTATUS + "/{id}")
	public ResponseEntity<?> update(@Valid OrderStatusRequestDTO dto, @PathVariable int id) {
		return super.ok(this.orderStatusService.update(dto, id), CRUD.FIND);
	}
	

}
