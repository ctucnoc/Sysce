package com.sys.mype.sysce.pe.errorhandler;

public class SysceValidationError extends SysceSubError {

	private String object;
	private String field;
	private Object rejectValue;
	private String message;

	public SysceValidationError(String object, String message) {
		this.object = object;
		this.message = message;
	}

	public SysceValidationError(String object, String field, Object rejectValue, String message) {
		this.object = object;
		this.field = field;
		this.rejectValue = rejectValue;
		this.message = message;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Object getRejectValue() {
		return rejectValue;
	}

	public void setRejectValue(Object rejectValue) {
		this.rejectValue = rejectValue;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
