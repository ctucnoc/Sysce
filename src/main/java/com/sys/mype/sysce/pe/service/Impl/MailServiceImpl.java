package com.sys.mype.sysce.pe.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import com.sys.mype.sysce.pe.dto.SendEmailDTO;
import com.sys.mype.sysce.pe.service.MailService;

@Service
public class MailServiceImpl implements MailService {

	final JavaMailSender javaMailSender;
	final TemplateEngine templateEngine;

	@Value("${spring.mail.username}")
	private String remitente;

	public MailServiceImpl(JavaMailSender javaMailSender, TemplateEngine templateEngine) {
		this.javaMailSender = javaMailSender;
		this.templateEngine = templateEngine;
	}

	@Override
	public void sendEmail(SendEmailDTO dto) {
		MimeMessage message = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			helper.setFrom(remitente);
			helper.setTo(getTo(dto.getTo()));
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("$[URL]", "cristian tucno conde");
			String text = ParamMail(dto.getHtmlTemplate(), model);
			helper.setSubject(dto.getSubject());
			helper.setText(text, true);
			this.javaMailSender.send(message);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public String[] getTo(List<String> list) {
		String[] array = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			array[i] = list.get(i);
		}
		return array;
	}

	private String ParamMail(String html_template, Map<String, Object> maps) {
		Context context = new Context();
		context.setVariable("URL", "hola");
		return templateEngine.process(html_template, context);
	}

}
