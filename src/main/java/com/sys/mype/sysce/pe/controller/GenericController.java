package com.sys.mype.sysce.pe.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.ObjectDTO;
import com.sys.mype.sysce.pe.dto.SystemDTO;
import com.sys.mype.sysce.pe.util.CRUD;

public class GenericController {

	protected ResponseEntity<ObjectDTO> ok(Object obj, CRUD crud) {
		String autorName = "Digital Corp Perú SAC";
		HttpStatus httpStatus = HttpStatus.OK;
		switch (crud) {
		case REGISTER:
			httpStatus=HttpStatus.CREATED;
			break;
		default:
			break;
		}
		return ResponseEntity
				.status(httpStatus).body(
						ObjectDTO.builder()
								.systemInfo(SystemDTO.builder().name(SysceConstant.API_NAME)
										.verssion(SysceConstant.API_VERSION).autor(autorName).build())
								.data(obj).build());
	}
}
