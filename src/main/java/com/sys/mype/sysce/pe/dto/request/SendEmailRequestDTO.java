package com.sys.mype.sysce.pe.dto.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendEmailRequestDTO {
	private String from;
	private List<String> to;
	private String subject;
	private String htmlTemplate;
	private List<EmailDataRequestDTO> data;
}
