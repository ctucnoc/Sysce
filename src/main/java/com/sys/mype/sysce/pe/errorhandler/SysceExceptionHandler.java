package com.sys.mype.sysce.pe.errorhandler;

import com.sys.mype.sysce.pe.constant.SysceConstant;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpStatusCodeException;

@RestControllerAdvice
public class SysceExceptionHandler {

    @ExceptionHandler(HttpStatusCodeException.class)
    protected SysceError handleHttpRestClient(HttpStatusCodeException ex) {
        SysceError sysceError = null;
        if (ex.getStatusCode().is4xxClientError()) {
            sysceError = new SysceError(ex.getStatusCode(), SysceConstant.PREFIX_CLIENT_ERROR);
        } else if (ex.getStatusCode().is5xxServerError()) {
            sysceError = new SysceError(ex.getStatusCode(), SysceConstant.PREFIX_SERVER_ERROR);
        }
        sysceError.setMessage(ex.getStatusText());
        return sysceError;
    }

    @ExceptionHandler(SysceEntityNotFoundException.class)
    protected SysceError handleEntityNotFound(SysceEntityNotFoundException ex) {
        SysceError sysceError = new SysceError(HttpStatus.NOT_FOUND,
                SysceConstant.PREFIX_CLIENT_ERROR + SysceConstant.NOT_FOUND);
        sysceError.setMessage(ex.getMessage());
        return sysceError;
    }

    @ExceptionHandler(SysceGenericClientException.class)
    protected SysceError handleGenericClientException(SysceGenericClientException ex) {
        SysceError sysceError = new SysceError(ex.getHttpStatus(),
                SysceConstant.PREFIX_CLIENT_ERROR);
        sysceError.setMessage(ex.getMessage());
        sysceError.setSubErrors(ex.getSubErrors());
        return sysceError;
    }

    @ExceptionHandler(SysceUnauthorizedException.class)
    protected SysceError handleEntityUnauthorized(SysceUnauthorizedException ex) {
        SysceError sysceError = new SysceError(HttpStatus.UNAUTHORIZED,
                SysceConstant.PREFIX_CLIENT_ERROR + SysceConstant.UNAUTHORIZED);
        sysceError.setMessage(ex.getMessage());
        return sysceError;
    }
}
