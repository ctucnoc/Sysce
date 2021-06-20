package com.sys.mype.sysce.pe.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class KindProductRequestDTO {

	@NotNull
	@NotBlank
	private String productId;
	
	@NotNull
	@NotBlank
	private int kindSaleId;
	
	@NotNull
	@NotBlank
	private double precio;
}
