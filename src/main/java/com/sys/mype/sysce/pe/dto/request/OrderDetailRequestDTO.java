package com.sys.mype.sysce.pe.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailRequestDTO {
	
	@NotNull
	private int count;

	@NotNull
	private double amount;
	
	@NotNull
	private double discount;
	
	@NotNull
	private double netAmount;
	
	@NotNull
	private double unitPreci;
	
	@NotNull
	@NotBlank
	private String productName;
	
	@NotNull
	private Long kindProductId;
}
