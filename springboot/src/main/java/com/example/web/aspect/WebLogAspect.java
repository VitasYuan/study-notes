package com.example.web.aspect;

import com.example.business.scope.RequestScopeBean;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


/**
 * @author yuanweipeng
 * @date 2018-01-19
 **/
@Aspect
@Component
public class WebLogAspect {

    @Autowired
    private RequestScopeBean requestScopeBean;

    private Logger logger = LoggerFactory.getLogger("WEB_REQUEST_LOG");

    @Pointcut("execution(public * com.example.web.controller..*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void before(JoinPoint joinPoint) throws Throwable{
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("Url:" + request.getRequestURL().toString());
        logger.info("Ip:" + request.getRemoteAddr() );
        logger.info("Http method:" + request.getMethod());
        logger.info("Class method:" + joinPoint.getSignature().getDeclaringTypeName() +
                "." + joinPoint.getSignature().getName());
        logger.info("Args:" + Arrays.toString(joinPoint.getArgs()));
        requestScopeBean.setLocal((String) request.getAttribute("local"));
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void afterReturning(Object ret) throws Throwable{
        logger.info("Response:" + ret);
    }
}
