package com.imooc.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018/3/5.
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.imooc.controller.GirlController.*(..))")
    public void log(){

    }

    @Before("log()")
    public void before(JoinPoint joinPoint){

        logger.info("111111前置方法执行");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//         HttpServletRequest是java的包
        HttpServletRequest request = attributes.getRequest();

//        url
        logger.info("url={}",request.getRequestURL());

//      method
        logger.info("method={}",request.getMethod());

//        ip
        logger.info("ip={}",request.getRemoteAddr());

//        类方法
        logger.info("class={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());

//        参数
        logger.info("args={}",joinPoint.getArgs());
    }

    @After("log()")
    public void after(){
        logger.info("22222后置方法执行");
    }

    @AfterReturning( returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object){
//        logger.info("object={}",object.toString());
    }
}
