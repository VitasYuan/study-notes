package com.example.web.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.annotation.Target;

/**
 * @author yuanweipeng
 * @date 2018-01-22
 **/
@Component
@Aspect
public class AnnotationAspect {

    @Pointcut("within(com.example.business.dictionary..*)")
    public void mybatisOp(){}

    @Before("mybatisOp()")
    public void before(JoinPoint joinPoint){

        System.out.println("MethodName:=" + joinPoint.getSignature().getName());
        System.out.println("getDeclaringTypeName: " + joinPoint.getSignature().getDeclaringTypeName());
    }

    @AfterThrowing(value = "mybatisOp()", throwing = "ex")
    public void exception(JoinPoint joinPoint, Exception ex){
        System.out.println("=========================");
        ex.printStackTrace();
        System.out.println(ex.getMessage());
        System.out.println("=========================");
    }

}
