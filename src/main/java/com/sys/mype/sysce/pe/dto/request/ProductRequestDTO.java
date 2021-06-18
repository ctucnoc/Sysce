package com.sys.mype.sysce.pe.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ProductRequestDTO {
	
	@NotNull
	@NotBlank
    private String name;
	
	@NotNull
	@NotBlank
    private String summary;
	
	@NotNull
	@NotBlank
    private String kit;
	
	@NotNull
	@NotBlank
    private String generic;
	
	@NotNull
	@NotBlank
    private String batch;
	
	@NotNull
	@NotBlank
    private String expDate;
	
	@NotNull
	@NotBlank
    private String refrigeration;
	
	@NotNull
	@NotBlank
    private int subCategoryId;

}
