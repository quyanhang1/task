package com.imooc.handle;

import com.imooc.ResultUtil;
import com.imooc.dimain.Result;
import com.imooc.exception.GirlException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2018/3/5.
 */
@ControllerAdvice
public class ExceptionHandle {

//    处理异常
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof GirlException){
            GirlException girlException = (GirlException) e;
            return ResultUtil.srror(girlException.getCode(),girlException.getMessage());
        }else{
            return ResultUtil.srror(-1,"未知异常");
        }

    }
}
