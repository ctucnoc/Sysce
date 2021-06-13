package com.sys.mype.sysce.pe.errorhandler;

import com.sys.mype.sysce.pe.constant.SysceConstant;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class SysceExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(HttpStatusCodeException.class)
    protected ResponseEntity<Object> handleHttpRestClient(HttpStatusCodeException ex) {
        SysceError sysceError = null;
        if (ex.getStatusCode().is4xxClientError()) {
            sysceError = new SysceError(ex.getStatusCode(), SysceConstant.PREFIX_CLIENT_ERROR);
        } else if (ex.getStatusCode().is5xxServerError()) {
            sysceError = new SysceError(ex.getStatusCode(), SysceConstant.PREFIX_SERVER_ERROR);
        }
        sysceError.setMessage(ex.getStatusText());
        return buildResponseEntity(sysceError);
    }
    
    @ExceptionHandler(SysceEntityUnprocessableException.class)
    protected ResponseEntity<Object> handleConflict(SysceEntityUnprocessableException ex) {
        SysceError sysceError = new SysceError(HttpStatus.UNPROCESSABLE_ENTITY,
                SysceConstant.PREFIX_CLIENT_ERROR + SysceConstant.UNPROCESSABLE_ENTITY);
        sysceError.setMessage(ex.getMessage());
        return buildResponseEntity(sysceError);
    }

    @ExceptionHandler(SysceEntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(SysceEntityNotFoundException ex) {
        SysceError sysceError = new SysceError(HttpStatus.NOT_FOUND,
                SysceConstant.PREFIX_CLIENT_ERROR + SysceConstant.NOT_FOUND);
        sysceError.setMessage(ex.getMessage());
        return buildResponseEntity(sysceError);
    }

    @ExceptionHandler(SysceGenericClientException.class)
    protected ResponseEntity<Object> handleGenericClientException(SysceGenericClientException ex) {
        SysceError sysceError = new SysceError(ex.getHttpStatus(),
                SysceConstant.PREFIX_CLIENT_ERROR);
        sysceError.setMessage(ex.getMessage());
        sysceError.setSubErrors(ex.getSubErrors());
        return buildResponseEntity(sysceError);
    }

    @ExceptionHandler(SysceUnauthorizedException.class)
    protected ResponseEntity<Object> handleEntityUnauthorized(SysceUnauthorizedException ex) {
        SysceError sysceError = new SysceError(HttpStatus.UNAUTHORIZED,
                SysceConstant.PREFIX_CLIENT_ERROR + SysceConstant.UNAUTHORIZED);
        sysceError.setMessage(ex.getMessage());
        return buildResponseEntity(sysceError);
    }
    
    @ExceptionHandler(SysceGenericServerException.class)
    protected ResponseEntity<Object> handleGenericServerException(SysceGenericServerException ex) {
    	SysceError sysceError = null;
        if(ex.getCode()!=null){
        	sysceError = new SysceError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getCode());
        }else{
        	sysceError = new SysceError(HttpStatus.INTERNAL_SERVER_ERROR,
                    SysceConstant.PREFIX_SERVER_ERROR + SysceConstant.INTERNAL_SERVER_ERROR);
        }
        sysceError.setMessage(ex.getMessage());
        return buildResponseEntity(sysceError);
    }
    

    @Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "Malformed JSON request";
        return buildResponseEntity(new SysceError(HttpStatus.BAD_REQUEST,SysceConstant.PREFIX_CLIENT_ERROR + SysceConstant.BAD_REQUEST, error, ex));
    }
    
    private ResponseEntity<Object> buildResponseEntity(SysceError sysceError) {
        return new ResponseEntity<>(sysceError, sysceError.getHttpStatus());
    }
    

}
