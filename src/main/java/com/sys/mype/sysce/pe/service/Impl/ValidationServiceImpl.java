package com.sys.mype.sysce.pe.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.SendEmailDTO;
import com.sys.mype.sysce.pe.errorhandler.SysceEntityNotFoundException;
import com.sys.mype.sysce.pe.model.BHtmlTemplate;
import com.sys.mype.sysce.pe.repository.HtmlTemplateRepository;
import com.sys.mype.sysce.pe.service.MailService;
import com.sys.mype.sysce.pe.service.ValidationService;

@Service
@Transactional
public class ValidationServiceImpl implements ValidationService{

	final MailService mailService;
	final HtmlTemplateRepository htmlTemplateRepository;
	
	public ValidationServiceImpl(MailService mailService, HtmlTemplateRepository htmlTemplateRepository) {
		this.mailService = mailService;
		this.htmlTemplateRepository = htmlTemplateRepository;
	}

	@Override
	public void codeSendMail(String mail) {
		BHtmlTemplate bHtmlTemplate=this.htmlTemplateRepository.findByHtmlTemplateCodeAndHtmlTemplateStatus(SysceConstant.HTML_SEND_EMAIL, SysceConstant.STATE_ACTIVE).orElseThrow(()->new SysceEntityNotFoundException("not found code"));
		SendEmailDTO dto=new SendEmailDTO();
		List<String> to=new ArrayList<>();
		to.add(mail);
		dto.setTo(to);
		dto.setSubject("CÓDIGO DE VERIFICACIÓN");
		dto.setHtmlTemplate(bHtmlTemplate.getHtmlTempleteContent());
		this.mailService.sendEmail(dto);
	}
	
	
}
