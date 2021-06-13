package com.sys.mype.sysce.pe.util;

import java.lang.reflect.Field;

import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.HrefEntityDTO;
import com.sys.mype.sysce.pe.errorhandler.SysceGenericServerException;

public final class Util {

    public static boolean validateEmptyField(String word) {
        return word != null && word != "";
    }
    
	public static HrefEntityDTO createHrefFromResource(Object id, SysceResources resource)
			throws SysceGenericServerException {
		HrefEntityDTO hrefEntity = new HrefEntityDTO();
		try {
			StringBuilder builder = new StringBuilder();
			Field field = SysceConstant.class.getDeclaredField("RESOURCE_" + resource + "S");
			Object valueResource = field.get("");
			builder.append(valueResource);
			field = SysceConstant.class.getDeclaredField("RESOURCE_" + resource + "S_" + resource);
			valueResource = field.get("");
			builder.append(valueResource).append("/").append(id);
			hrefEntity.setId(id);
			hrefEntity.setHref(builder.toString());
		} catch (Exception e) {
			throw new SysceGenericServerException("Error generating href resource");
		}
		return hrefEntity;
	}
}
