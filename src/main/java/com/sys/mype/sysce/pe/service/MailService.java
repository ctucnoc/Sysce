package com.sys.mype.sysce.pe.service;

import com.sys.mype.sysce.pe.dto.request.SendEmailRequestDTO;

public interface MailService {
	public void sendEmail(SendEmailRequestDTO dto);
}
