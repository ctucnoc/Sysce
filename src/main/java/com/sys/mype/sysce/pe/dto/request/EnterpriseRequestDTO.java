package com.sys.mype.sysce.pe.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class EnterpriseRequestDTO {
	
	@NotNull
	@NotBlank
    private String name;
	
	@NotNull
	@NotBlank
    private String img;
	
	@NotNull
	@NotBlank
    private String address;
	
	@NotNull
	@NotBlank
    private String phone;
	
	@NotNull
	@NotBlank
    private String ruc;
	
	@NotNull
	@NotBlank
    private String mail;

}
