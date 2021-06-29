package com.sys.mype.sysce.pe.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.request.OrderRequestDTO;
import com.sys.mype.sysce.pe.service.OrderService;
import com.sys.mype.sysce.pe.util.CRUD;

@RestController
@RequestMapping(SysceConstant.RESOURCE_ORDERS)
@CrossOrigin(SysceConstant.PATH_FROTEND_SYSCE)
public class OrderController extends GenericController {

	final OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping(SysceConstant.RESOURCE_ORDERS_ORDER)
	public ResponseEntity<?> add(@Valid @RequestBody OrderRequestDTO dto) {
		return super.ok(this.orderService.save(dto), CRUD.REGISTER);
	}
	
	@GetMapping(SysceConstant.RESOURCE_ORDERS_ORDER+"/{id}")
	public ResponseEntity<?> findById(@PathVariable String id){
		return super.ok(this.orderService.findById(id), CRUD.FIND);
	}

}
