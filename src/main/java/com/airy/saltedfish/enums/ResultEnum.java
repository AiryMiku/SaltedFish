package com.airy.saltedfish.enums;

/**
 * Created by Airy on 2017/11/14
 */

public enum ResultEnum {
    UNKNOW_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    PRIMARY_SCHOOL(100,"小学"),
    MIDDLE_SCHOOL(101,"初中");

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
