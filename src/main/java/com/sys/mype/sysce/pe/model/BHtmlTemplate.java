package com.sys.mype.sysce.pe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "html_template",schema = "util")
@Data
public class BHtmlTemplate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_html_template")
	private int htmlTemplateId;
	
	@Column(name = "ds_code",length = 15)
	private String htmlTemplateCode;
	
	@Column(name = "ds_content")
	private String htmlTempleteContent;
	
	@Column(name = "sn_active",length = 1)
	private String htmlTemplateStatus;
}
