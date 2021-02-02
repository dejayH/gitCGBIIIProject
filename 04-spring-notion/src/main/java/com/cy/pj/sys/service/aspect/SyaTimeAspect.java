package com.cy.pj.sys.service.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Aspect
@Component
public class SyaTimeAspect {
    @Pointcut("@annotation(com.cy.pj.common.annotation.RequiredTime)")
    public void doTime() {
    }

    @Before("doTime()")
    public void doBefore() {
        System.out.println("@Before");
    }

    @After("doTime()")
    public void doAfter() {
        System.out.println("@After");
    }

    @AfterReturning("doTime()")
    public void doAfterReturning() {
        System.out.println("@AfterReturning");
    }

    @AfterThrowing("doTime()")
    public void doAfterThrowing() {
        System.out.println("@AfterReturning");
    }

    @Around("doTime()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("SysTimeAspect.@Around.Before");
        try {
            Object result = joinPoint.proceed();
            System.out.println("@Around.AfterReturning");
            return result;
        } catch (Exception e) {
            System.out.println("@Around.AfterThrowing");
            throw e;
        } finally {
            System.out.println("@Around.After");
        }

    }
}
