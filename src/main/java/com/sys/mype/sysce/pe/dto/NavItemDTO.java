package com.sys.mype.sysce.pe.dto;

import java.util.List;
import lombok.Data;

@Data
public class NavItemDTO {
	private String displayName;
	private String iconName;
	private String route;
	private String code;
	private List<ItemDTO> children;
}
