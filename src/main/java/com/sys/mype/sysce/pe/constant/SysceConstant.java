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
	
	// ORDERS
	public static final Long CANT_ORDERS = (long) 0;

	public static final String API_VERSION = "v1";
	public static final String API_NAME = "SISTEMA DE GESTION COMERCIAL Y EMPRESARIAL";

	// =============================================================================================
	// PATH DEL SISTEMA ADMINISTRADOR SYSCE
	// =============================================================================================
	public static final String RESOURCE_GENERIC = "/sysce-app";
	public static final String RESOURCE_ENTERPRISES = API_VERSION + RESOURCE_GENERIC + "/enterprises";
	public static final String RESOURCE_ENTERPRISES_ENTERPRISE = "/enterprise";
	public static final String RESOURCE_SUBSIDIARYS = API_VERSION + RESOURCE_GENERIC + "/subsidiaries";
	public static final String RESOURCE_SUBSIDIARYS_SUBSIDIARY = "/subsidiary";
	public static final String RESOURCE_CATEGORYS = API_VERSION + RESOURCE_GENERIC + "/categories";
	public static final String RESOURCE_CATEGORYS_CATEGORY = "/category";
	public static final String RESOURCE_SUBCATEGORYS = API_VERSION + RESOURCE_GENERIC + "/sub-categories";
	public static final String RESOURCE_SUBCATEGORYS_SUBCATEGORY = "/sub-category";
	public static final String RESOURCE_PRODUCTS = API_VERSION + RESOURCE_GENERIC + "/products";
	public static final String RESOURCE_PRODUCTS_PRODUCT = "/product";
	public static final String RESOURCE_SIP = API_VERSION + RESOURCE_GENERIC + "/sip";
	public static final String RESOURCE_PERSONS = API_VERSION + RESOURCE_GENERIC + "/persons";
	public static final String RESOURCE_PERSONS_PERSON = "/person";
	public static final String RESOURCE_USERS = API_VERSION + RESOURCE_GENERIC + "/users";
	public static final String RESOURCE_USERS_USER = "/user";
	public static final String RESOURCE_SIP_PERMIT_ALL = "/v1/sysce-app/sip/login";
	public static final String RESOURCE_SCREENS = API_VERSION + RESOURCE_GENERIC + "/screens";
	public static final String RESOURCE_SCREENS_SCREEN = "/screen";
	public static final String RESOURCE_MODULES = API_VERSION + RESOURCE_GENERIC + "/modules";
	public static final String RESOURCE_MODULES_MODULE = "/module";
	public static final String RESOURCE_MODULE_SCREENS = API_VERSION + RESOURCE_GENERIC + "/modules-screens";
	public static final String RESOURCE_MODULE_SCREENS_SCREEN = "/module-screen";
	public static final String RESOURCE_KINDSALES = API_VERSION + RESOURCE_GENERIC + "/kinds";
	public static final String RESOURCE_KINDSALES_KINDSALE = "/kind";
	public static final String RESOURCE_KINDPRODUCTS = API_VERSION + RESOURCE_GENERIC + "/kindProducts";
	public static final String RESOURCE_KINDPRODUCTS_KINDPRODUCT = "/kind-product";
	public static final String RESOURCE_ORDERTYPES = API_VERSION + RESOURCE_GENERIC + "/orderTypes";
	public static final String RESOURCE_ORDERTYPES_ORDERTYPE = "/order-type";

	// =============================================================================================
	// PATH DEL SISTEMA SYSCE FROENT-END
	// =============================================================================================
	public static final String PATH_FROTEND_SYSCE = "*";
}
