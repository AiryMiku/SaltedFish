package com.airy.saltedfish.utils;


import com.airy.saltedfish.domain.Result;

/**
 * Created by Airy on 2017/11/6
 */

public class ResultUtil {

    public static Result success(Object o){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("success");
        result.setData(o);
        return result;
    }

    public static Result result(String msg){
        Result result = new Result();
        result.setCode(0);
        result.setMsg(msg);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

}
