package com.nest.renting.common.result;

import lombok.Getter;

/**
 * Unified response status code enumeration.
 * This enumeration defines a set of common response status codes and their corresponding messages,
 * which are used to represent the result of various operations in the application,
 * such as success, failure, parameter errors, and authentication failures.
 */
@Getter
public enum ResultCodeEnum {

    SUCCESS(200, "Success"),
    FAIL(201, "Failure"),
    PARAM_ERROR(202, "Invalid parameters"),
    SERVICE_ERROR(203, "Service exception"),
    DATA_ERROR(204, "Data error"),
    ILLEGAL_REQUEST(205, "Illegal request"),
    REPEAT_SUBMIT(206, "Duplicate submission"),

    ADMIN_ACCOUNT_EXIST_ERROR(301, "Account already exists"),
    ADMIN_CAPTCHA_CODE_ERROR(302, "Incorrect captcha code"),
    ADMIN_CAPTCHA_CODE_EXPIRED(303, "Captcha code expired"),
    ADMIN_CAPTCHA_CODE_NOT_FOUND(304, "Captcha code not provided"),

    ADMIN_LOGIN_AUTH(305, "Not logged in"),
    ADMIN_ACCOUNT_NOT_EXIST_ERROR(306, "Account does not exist"),
    ADMIN_ACCOUNT_ERROR(307, "Incorrect username or password"),
    ADMIN_ACCOUNT_DISABLED_ERROR(308, "Account has been disabled"),
    ADMIN_ACCESS_FORBIDDEN(309, "Access denied"),
    ADMIN_APARTMENT_DELETE_ERROR(310, "Please delete associated rooms first"),

    APP_LOGIN_AUTH(501, "Not logged in"),
    APP_LOGIN_PHONE_EMPTY(502, "Phone number is empty"),
    APP_LOGIN_CODE_EMPTY(503, "Verification code is empty"),
    APP_SEND_SMS_TOO_OFTEN(504, "Verification code sent too frequently"),
    APP_LOGIN_CODE_EXPIRED(505, "Verification code expired"),
    APP_LOGIN_CODE_ERROR(506, "Incorrect verification code"),
    APP_ACCOUNT_DISABLED_ERROR(507, "User account has been disabled"),

    TOKEN_EXPIRED(601, "Token expired"),
    TOKEN_INVALID(602, "Invalid token");

    private final Integer code;

    private final String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
