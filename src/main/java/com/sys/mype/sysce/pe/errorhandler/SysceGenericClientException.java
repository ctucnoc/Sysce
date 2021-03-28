package com.sys.mype.sysce.pe.errorhandler;

import org.springframework.http.HttpStatus;

import java.util.List;

public class SysceGenericClientException extends RuntimeException {

    private HttpStatus httpStatus;
    private List<SysceSubError> subErrors;

    public SysceGenericClientException() {
        super();
    }

    public SysceGenericClientException(String message, Throwable ex) {
        super(message, ex);
    }

    public SysceGenericClientException(String message) {
        super(message);
    }

    public SysceGenericClientException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public SysceGenericClientException(Throwable ex) {
        super(ex);
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public List<SysceSubError> getSubErrors() {
        return subErrors;
    }

    public void setSubErrors(List<SysceSubError> subErrors) {
        this.subErrors = subErrors;
    }

    @Override
    public String toString() {
        return "CivilAgreementGenericClientException{" +
                "httpStatus=" + httpStatus +
                ", subErrors=" + subErrors +
                '}';
    }
}
