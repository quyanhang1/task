package com.imooc.service;

import com.imooc.GirlRepostory.GirlRepostory;
import com.imooc.dimain.Girl;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.GirlException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/3/5.
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepostory girlRepostory;
    public void getAge(Integer id) throws Exception {
        Girl girl = girlRepostory.findOne(id);
        Integer age = girl.getAge();
        if(age<10){
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age >=10 && age<16){
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }else if(age>=16){
            throw new GirlException(ResultEnum.SUCCESS);
        }

    }

    public Girl findOne(Integer id){
        return girlRepostory.findOne(id);
    }
}
