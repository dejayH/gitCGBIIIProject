package com.cy.pj.sys.service.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author uid
 */
@Aspect
@Component
public class SysLogAspect {
    /**
     * 切入点
     */
    @Pointcut("@annotation(com.cy.pj.common.annotation.RequiredLog)")
    public void doLog() {}

    /**
     * @Around("@annotation(com.cy.pj.common.annotation.RequiredLog)")
     */
    @Around("doLog()")
    public Object doLogAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("before:"+System.currentTimeMillis());
        Object result = joinPoint.proceed();
        System.out.println("after:"+System.currentTimeMillis());
        return result;
    }

}
