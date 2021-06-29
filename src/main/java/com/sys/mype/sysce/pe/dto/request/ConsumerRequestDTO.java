package com.sys.mype.sysce.pe.dto.request;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsumerRequestDTO {
	
	@NotNull
	@NotBlank
	private String name;
	
	@NotNull
	@NotBlank
	private String lastName;
	
	@NotNull
	@NotBlank
	private String cell;
	
	@NotNull
	@NotBlank
	private Date birthday;
	
	@NotNull
	@NotBlank
	private String direction;
	
	@NotNull
	@NotBlank
	private String mail;
	
	@NotNull
	@NotBlank
	private int subsidiaryId;
}
