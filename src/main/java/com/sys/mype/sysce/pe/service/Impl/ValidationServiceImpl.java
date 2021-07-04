package com.sys.mype.sysce.pe.service.Impl;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.request.EmailDataRequestDTO;
import com.sys.mype.sysce.pe.dto.request.SendEmailRequestDTO;
import com.sys.mype.sysce.pe.errorhandler.SysceEntityNotFoundException;
import com.sys.mype.sysce.pe.errorhandler.SysceGenericClientException;
import com.sys.mype.sysce.pe.model.BHtmlTemplate;
import com.sys.mype.sysce.pe.repository.HtmlTemplateRepository;
import com.sys.mype.sysce.pe.service.MailService;
import com.sys.mype.sysce.pe.service.ValidationService;
import com.sys.mype.sysce.pe.util.Util;

@Service
@Transactional
public class ValidationServiceImpl implements ValidationService{
	
	@Value("${spring.mail.username}")
	private String remitente;

	final MailService mailService;
	final HtmlTemplateRepository htmlTemplateRepository;
	final Util util;
	
	public ValidationServiceImpl(MailService mailService, HtmlTemplateRepository htmlTemplateRepository,Util util) {
		this.mailService = mailService;
		this.htmlTemplateRepository = htmlTemplateRepository;
		this.util=util;
	}

	@Override
	public void codeSendMail(String mail) {
		if(!util.validateEmail(mail.trim()))
			throw new SysceGenericClientException("mail no valid", HttpStatus.BAD_REQUEST);
		BHtmlTemplate bHtmlTemplate=this.htmlTemplateRepository.findByHtmlTemplateCodeAndHtmlTemplateStatus(SysceConstant.HTML_SEND_EMAIL, SysceConstant.STATE_ACTIVE).orElseThrow(()->new SysceEntityNotFoundException("not found code"));
		SendEmailRequestDTO dto=new SendEmailRequestDTO();
		List<String> to=new ArrayList<>();
		to.add(mail);
		dto.setFrom(remitente);
		dto.setTo(to);
		dto.setSubject("CÓDIGO DE VERIFICACIÓN");
		dto.setHtmlTemplate(bHtmlTemplate.getHtmlTempleteContent());
		dto.setData(this.dataEmail("54321"));
		this.mailService.sendEmail(dto);
	}
	
	private List<EmailDataRequestDTO> dataEmail(String codigoVerificacion){
		List<EmailDataRequestDTO> data=new ArrayList<>();
		EmailDataRequestDTO dto=new EmailDataRequestDTO();
		dto.setKey("$[URL]");
		dto.setValue(codigoVerificacion);
		data.add(dto);
		return data;
	}
	
	
}
