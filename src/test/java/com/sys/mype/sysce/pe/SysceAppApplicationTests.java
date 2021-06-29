package com.sys.mype.sysce.pe;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sys.mype.sysce.pe.dto.SendEmailDTO;
import com.sys.mype.sysce.pe.service.MailService;

@SpringBootTest
class SysceAppApplicationTests {
	
	@Autowired
	MailService mailService;

	@Test
	void contextLoads() {
		SendEmailDTO dto=new SendEmailDTO();
		List<String> to=new ArrayList<>();
		to.add("ctc.tucno@gmail.com");
		dto.setTo(to);
		dto.setSubject("hola");
		this.mailService.sendEmail(dto);
	}

}
