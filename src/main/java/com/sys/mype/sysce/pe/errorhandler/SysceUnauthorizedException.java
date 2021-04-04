package com.sys.mype.sysce.pe.errorhandler;

public class SysceUnauthorizedException extends RuntimeException{

    public SysceUnauthorizedException() {
        super();
    }

    public SysceUnauthorizedException(String message, Throwable ex)	{
        super(message, ex);
    }

    public SysceUnauthorizedException(String message) {
        super(message);
    }

    public SysceUnauthorizedException(Throwable ex) {
        super(ex);
    }
}
