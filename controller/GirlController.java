package com.imooc.controller;

import com.imooc.GirlRepostory.GirlRepostory;
import com.imooc.ResultUtil;
import com.imooc.dimain.Girl;
import com.imooc.dimain.Result;
import com.imooc.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Administrator on 2018/3/4.
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRepostory girlRepostory;
    @Autowired
    private GirlService girlService;

//    查询所有列表
    @GetMapping(value = "/girl")
    public List<Girl> getAll(){
        return girlRepostory.findAll();
    }

    @PostMapping(value = "/girl")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            String msg = bindingResult.getFieldError().getDefaultMessage();
            Result error = ResultUtil.srror(0, msg);
            return error;
        }

        Result success = ResultUtil.success(girl);
        return success;
    }

    @GetMapping("/girl1/{id}")
    public Girl getGirlById(@PathVariable("id") Integer id){
        return girlRepostory.findOne(id);
    }

    @PutMapping("/girl/{id}")
    public Girl updateGirlById(@PathVariable("id") Integer id,
                                @RequestParam("cupSize") String cupSize,
                               @RequestParam("age") Integer age,
                                @RequestParam("money") Integer money){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        girl.setMoney(money);

        return girlRepostory.save(girl);
    }

    @DeleteMapping(value = "/girl/{id}")
    public Integer deleteGirl(@PathVariable("id") Integer id){
        girlRepostory.delete(id);
        return id;
    }

//    @GetMapping(value = "/girl/age/{age}")
//    public List<Girl> findGirlByAge(@PathVariable("age") Integer age){
//        List<Girl> girlByAge = girlRepostory.findGirlByAge(age);
//        return girlByAge;
//    }

    @GetMapping("/girl/age/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);

    }


}
