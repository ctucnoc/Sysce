package com.sys.mype.sysce.pe.errorhandler;

public class SysceEntityNotFoundException extends RuntimeException {

    public SysceEntityNotFoundException() {
        super();
    }

    public SysceEntityNotFoundException(String message, Throwable ex)	{
        super(message, ex);
    }

    public SysceEntityNotFoundException(String message) {
        super(message);
    }

    public SysceEntityNotFoundException(Throwable ex) {
        super(ex);
    }
}
