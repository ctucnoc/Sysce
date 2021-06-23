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
import org.springframework.web.bind.annotation.RestController;
import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.request.OrderTypeRequestDTO;
import com.sys.mype.sysce.pe.service.OrderTypeService;
import com.sys.mype.sysce.pe.util.CRUD;

@RestController
@RequestMapping(SysceConstant.RESOURCE_ORDERTYPES)
@CrossOrigin(SysceConstant.PATH_FROTEND_SYSCE)
public class OrderTypeController extends GenericController{

	final OrderTypeService orderTypeService;

	public OrderTypeController(OrderTypeService orderTypeService) {
		this.orderTypeService = orderTypeService;
	}
	
	@PostMapping(SysceConstant.RESOURCE_ORDERTYPES_ORDERTYPE)
	public ResponseEntity<?> add(@Valid @RequestBody OrderTypeRequestDTO dto){
		return super.ok(this.orderTypeService.save(dto), CRUD.REGISTER);
	}
	
	@PutMapping(SysceConstant.RESOURCE_ORDERTYPES_ORDERTYPE+"/{id}")
	public ResponseEntity<?> add(@Valid @RequestBody OrderTypeRequestDTO dto,@PathVariable int id){
		return super.ok(this.orderTypeService.update(dto,id), CRUD.UPDATE);
	}
	
	@GetMapping(SysceConstant.RESOURCE_ORDERTYPES_ORDERTYPE+"/{id}")
	public ResponseEntity<?> findById(@PathVariable int id){
		return ok(this.orderTypeService.findById(id), CRUD.FIND);
	}
	
	@GetMapping(SysceConstant.RESOURCE_ORDERTYPES_ORDERTYPE)
	public ResponseEntity<?> findAll(){
		return ok(this.orderTypeService.findAll(), CRUD.FIND);
	}
	
	@PatchMapping(SysceConstant.RESOURCE_ORDERTYPES_ORDERTYPE+"/{id}")
	public ResponseEntity<?> delete(@PathVariable int id){
		return ok(this.orderTypeService.delete(id), CRUD.DELETE);
	}
	
}
