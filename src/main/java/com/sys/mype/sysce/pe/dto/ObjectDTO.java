package com.sys.mype.sysce.pe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ObjectDTO {
	private SystemDTO systemInfo;
	private Object data;
}
