package com.airy.saltedfish.domain;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by Airy on 2017/11/14
 */

public class Result<T> {

    private Integer code;
    private String msg;

    private T data;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }
}
