package com.sys.mype.sysce.pe.dto.request;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
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
	
	@NotNull
	@NotEmpty
	private List<OrderDetailRequestDTO> orderDetails;
}
