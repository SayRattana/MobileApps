package com.example.easylearning.helpers;

public class ValidationError {

    public static final ValidationError USER_ERROR = new ValidationError(
            100,
            "Username must be at least 4 characters");

    public static final ValidationError PASSWORD_ERROR = new ValidationError(
            101,
            "Password must be at least 6 characters");


    public static final ValidationError EMAIL_ERROR = new ValidationError(
            102,
            "Email is not in correct format");

    private Integer errorCode; //
    private String errorDetail;//EX: User and password must have at least 2 characters, ...

    public ValidationError(Integer errorCode, String errorDetail) {
        this.errorCode = errorCode;
        this.errorDetail = errorDetail;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getErrorDetail() {
        return errorDetail;
    }

}
