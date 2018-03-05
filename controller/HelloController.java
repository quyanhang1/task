package com.imooc.controller;

import com.imooc.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2018/3/4.
 */

@RestController
public class HelloController {

   @Autowired
   private GirlProperties girlProperties;

//    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @GetMapping(value = "/hello/{id}")
    public Integer say(@PathVariable(value = "id") Integer myId){

        return myId;
//        return  "index";
    }
}
