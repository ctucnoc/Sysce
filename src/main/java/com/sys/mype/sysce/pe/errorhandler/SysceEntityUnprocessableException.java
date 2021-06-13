package com.sys.mype.sysce.pe.errorhandler;

public class SysceEntityUnprocessableException extends RuntimeException{

    public SysceEntityUnprocessableException() {
        super();
    }

    public SysceEntityUnprocessableException(String message, Throwable ex)	{
        super(message, ex);
    }

    public SysceEntityUnprocessableException(String message) {
        super(message);
    }

    public SysceEntityUnprocessableException(Throwable ex) {
        super(ex);
    }
}
