package com.app_manager.util;

public abstract class Url {
    
    public static final String FIND_ALL = "/find/all";
    public static final String FIND_BY_ID = "/find/by-id/{id}";
    public static final String FIND_BY_NAME = "/find/by-name";
    public static final String FIND_BY_USERNAME = "/find/by-username";
    public static final String FIND_BY_EMAIL = "/find/by-email";

    public static final String INSERT = "/insert";
    public static final String UPDATE = "/update";
    public static final String UPDATE_BY_ID = "/update/{id}";
    public static final String DELETE = "/delete";
    public static final String DELETE_BY_ID = "/delete/{id}";
}
