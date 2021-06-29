package com.sys.mype.sysce.pe.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserLoinRequestDTO {
	
	@NotNull
	@NotBlank
    private String user;
	
	@NotNull
	@NotBlank
    private String ruc;
	
	@NotNull
	@NotBlank
    private String password;
}
