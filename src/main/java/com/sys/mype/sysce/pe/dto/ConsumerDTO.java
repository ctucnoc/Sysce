package com.sys.mype.sysce.pe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsumerDTO {
	private String id;
	private String name;
	private String lastName;
	private String direction;
	private String mail;
	private String amountVisit;
	private String cell;
	private GenericDTO subsidiary;
}
