package com.arun.usermanagement.util;

public class ApplicationConstants {

    public static final String KAFKA_LOCAL_SERVER_CONFIG = "localhost:9092";
    public static final String GROUP_ID_STRING = "group-id-string-1";
    public static final String TOPIC_NAME = "event.userManagement.confidential";
    public static final String KAFKA_LISTENER_CONTAINER_FACTORY = "kafkaListenerContainerFactory";
    public static final String GROUP_ID_JSON = "group-id-json-1";
    public static final String API_VERSION_V1 = "/api/v1";

    public static final String CREATE_USER = "/create-user";
    public static final String GET_USER = "/getUser/{id}";
    public static final String GET_ALL_USER = "/getAll-users";
    public static final String EDIT_USER = "/editUser/{id}";
    public static final String DELETE_USER = "/deleteUser/{id}";


    public static final String ROLE_USER = "USER";
    public static final String ROLE_USER_USERNAME= "user";

    public static final String ROLE_USER_PASSWORD = "1234";
    public static final String ADMIN_USER = "ADMIN";
    public static final String ADMIN_USER_USERNAME= "admin";
    public static final String ADMIN_USER_PASSWORD = "56789";
}
