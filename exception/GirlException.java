package com.imooc.exception;

import com.imooc.enums.ResultEnum;

/**
 * Created by Administrator on 2018/3/5.
 */

//spring只对RuntimeException异常回滚
public class GirlException extends RuntimeException{

    private Integer code;

    public GirlException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code=resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
