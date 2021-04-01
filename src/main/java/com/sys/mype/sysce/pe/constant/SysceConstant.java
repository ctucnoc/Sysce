package com.sys.mype.sysce.pe.constant;

public final class SysceConstant {

    // =============================================================================================
    // CODIGO DE ERROR DEL CLIENTE Y SERVIDOR
    // =============================================================================================


    // CLIENT ERRORS
    public static final String BAD_REQUEST = "401";
    public static final String UNAUTHORIZED = "402";
    public static final String FORBIDDEN = "403";
    public static final String NOT_FOUND = "404";
    public static final String METHOD_NOT_ALLOWED = "405";
    public static final String NOT_ACCEPTABLE = "406";
    public static final String CONFLICT = "409";
    public static final String UNPROCESSABLE_ENTITY = "422";
    public static final String EXPECTATION_FAILED = "417";

    // SERVER ERRORS
    public static final String INTERNAL_SERVER_ERROR = "501";
    public static final String NOT_IMPLEMENTED = "502";
    public static final String BAD_GATEWAY = "503";
    public static final String SERVICE_UNAVAILABLE = "504";
    public static final String GATEWAY_TIMEOUT = "505";
    public static final String NOT_VALIDATED = "506";

    // ERRORS
    public static final String PREFIX_SERVER_ERROR = "SRV";
    public static final String PREFIX_CLIENT_ERROR = "CLI";

    // STATES
    public static final String STATE_ACTIVE = "S";
    public static final String STATE_INACTIVE = "N";


    // =============================================================================================
    // PATH DEL SISTEMA ADMINISTRADOR SYSCE
    // =============================================================================================
    public static final String PATH_SYSCE_APP_ENTERPRISE = "api/sysce-app/enterprise";
    public static final String PATH_SYSCE_APP_SUBSIDIARY = "api/sysce-app/subsidiary";



    // =============================================================================================
    // PATH DEL SISTEMA SYSCE FROENT-END
    // =============================================================================================
    public static final String PATH_FROTEND_SYSCE = "http://localhost:8100";
}