package com.airy.saltedfish.handle;

import com.airy.saltedfish.domain.Result;
import com.airy.saltedfish.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by Airy on 2017/11/14
 */

@ControllerAdvice
public class ExceptionHandle {

    private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        LOGGER.error("[system error]{}",e);
        return ResultUtil.error(-1,"unknow error");
    }

}
