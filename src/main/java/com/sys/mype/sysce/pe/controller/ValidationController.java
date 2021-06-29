package com.sys.mype.sysce.pe.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.service.ValidationService;

@RestController
@RequestMapping(SysceConstant.RESOURCE_VALIDATIONS)
@CrossOrigin(SysceConstant.PATH_FROTEND_SYSCE)
public class ValidationController extends GenericController {

	final ValidationService validationService;

	public ValidationController(ValidationService validationService) {
		this.validationService = validationService;
	}

	@PostMapping(SysceConstant.RESOURCE_VALIDATIONS_VALIDATION)
	public void codeSendMail(@RequestParam String mail) {
		this.validationService.codeSendMail(mail);
	}
}
