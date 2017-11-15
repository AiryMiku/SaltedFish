package com.airy.saltedfish.exception;

import com.airy.saltedfish.enums.ResultEnum;

/**
 * Created by Airy on 2017/11/14
 */

public class MessageException extends RuntimeException {
    //spring只对re进行事务回滚

    private Integer code;

    public MessageException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
