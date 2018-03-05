package com.imooc;

import com.imooc.dimain.Result;

/**
 * Created by Administrator on 2018/3/5.
 */
public class ResultUtil {

    public static Result success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result srror(Integer code ,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
