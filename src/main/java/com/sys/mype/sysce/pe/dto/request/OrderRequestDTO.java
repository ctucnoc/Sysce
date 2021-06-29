package com.sys.mype.sysce.pe.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDTO {
	
	@NotNull
	private double totalPrice;
	
	@NotNull
	private double totalNetAmount;
	
	@NotNull
	private double totalDiscount;
	
	@NotNull
	private double totalImposition;
	
	@NotNull
	@NotBlank
	private String consumerId;
	
	@NotNull
	private int subsidiaryId;
	
	@NotNull
	private int orderTypeId;
}
