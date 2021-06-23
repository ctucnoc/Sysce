package com.sys.mype.sysce.pe.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderTypeRequestDTO {
	
	@NotNull
	@NotBlank
	private String description;
}
