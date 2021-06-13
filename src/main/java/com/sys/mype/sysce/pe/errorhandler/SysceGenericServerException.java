package com.sys.mype.sysce.pe.errorhandler;

public class SysceGenericServerException extends RuntimeException {

	private String code;

	public SysceGenericServerException() {
		super();
	}

	public SysceGenericServerException(String message, Throwable ex) {
		super(message, ex);
	}

	public SysceGenericServerException(String message) {
		super(message);
	}

	public SysceGenericServerException(String message, String code) {
		super(message);
		this.code = code;
	}

	public SysceGenericServerException(Throwable ex) {
		super(ex);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
