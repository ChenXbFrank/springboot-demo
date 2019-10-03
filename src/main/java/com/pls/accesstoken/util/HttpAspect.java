package com.pls.accesstoken.util;

import com.pls.accesstoken.model.Result;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 切面类
 * AOP切面，记录方法的调用，入参以及出參
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger LOGGER = LoggerFactory.getLogger(HttpAspect.class);

    @Autowired
    private ExceptionHandle exceptionHandle;

    @Pointcut("execution(public * com.pls.accesstoken.web.*.*(..))")
    public void log(){

    }

    /**
     * 这里是添加所有的请求的日志
     * @param joinPoint
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        LOGGER.info("url={}",request.getRequestURL());
        //method
        LOGGER.info("method={}",request.getMethod());
        //ip
        LOGGER.info("ip={}",request.getRemoteAddr());
        //class_method
        LOGGER.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName() + "," + joinPoint.getSignature().getName());
        //args[]
        LOGGER.info("args={}",joinPoint.getArgs());
    }

    /**
     * 这里是配置让返回结果全为Result
     * @param proceedingJoinPoint    这样是不能跳转页面的
     * @return
     * @throws Throwable
     */
    /*@Around("log()")
    public Result doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Result result = null;
        try {

        } catch (Exception e) {
            return exceptionHandle.exceptionGet(e);
        }
        if(result == null){
            return (Result) proceedingJoinPoint.proceed();
        }else {
            return result;
        }
    }

    /**
     * 打印输出结果
     * @param object
     */
    @AfterReturning(pointcut = "log()",returning = "object")
    public void doAfterReturing(Object object){
        LOGGER.info("response={}",object.toString());
    }
}
