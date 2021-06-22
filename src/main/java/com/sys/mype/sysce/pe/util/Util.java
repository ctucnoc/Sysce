package com.sys.mype.sysce.pe.util;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.HrefEntityDTO;
import com.sys.mype.sysce.pe.errorhandler.SysceGenericServerException;

@Component
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
	
	public Boolean validateCellphone(String cellphone) {
		if (cellphone != null) {
			if (!cellphone.matches("\\d{9}"))
				return false;
			else {
				Pattern pattern = Pattern.compile("^9.*");
				Matcher matcher = pattern.matcher(cellphone);
				return matcher.matches();
			}
		}
		return false;
	}

	public Boolean validateEmail(String email) {
		Pattern emailRegex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = emailRegex.matcher(email);
		return matcher.find();
	}

	public Boolean validateDocumentNumber(String documentNumber) {
		return documentNumber != null && documentNumber.matches("\\d{8}");
	}

	public Boolean validateNumberRUC(String ruc) {
		return ruc != null && ruc.matches("\\d{11}");
	}
}
