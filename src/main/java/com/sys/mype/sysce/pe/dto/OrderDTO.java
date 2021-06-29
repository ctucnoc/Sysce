package com.sys.mype.sysce.pe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
	private String id;
	private double totalPrice;
	private double totalNetAmount;
	private double totalDiscount;
	private double totalImposition;
}
