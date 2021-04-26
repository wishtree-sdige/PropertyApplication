package com.property.application.constant;


import lombok.AllArgsConstructor;
import lombok.Getter;

public class StatusConstants {

    @Getter
    @AllArgsConstructor
    public enum HttpConstants {

        SUCCESS(1, "Success"),
        BAD_CREDENTIAL(404, "Invalid"),
        CUSTOM_FIELD_VALIDATION(2, null),
        NOT_FOUND(3, "Not Found"),
        INTERNAL_SERVER_ERROR(0, "System error! Please try after some time"),
        UNAUTHORIZED(401, "User is not authorized");
        private Integer code;

        private String desc;

    }
}
