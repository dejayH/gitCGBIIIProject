package com.cy.pj.sys.service.aspect;

import com.cy.pj.common.annotation.RequiredLog;
import com.cy.pj.sys.pojo.SysLog;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author uid
 */
@Slf4j
@Aspect
@Component
public class SysLogAspect {
    /**
     * 切入点
     */
    @Pointcut("@annotation(com.cy.pj.common.annotation.RequiredLog)")
    public void doLog() {
    }

    /**
     * @Around("@annotation(com.cy.pj.common.annotation.RequiredLog)")
     */
    @Around("doLog()")
    public Object doLogAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long t1 = System.currentTimeMillis();
        log.info("before:" + t1);
        try {
            Object result = joinPoint.proceed();
            long t2 = System.currentTimeMillis();
            log.info("after:" + t2);
            doLogInfo(joinPoint,(t2-t1),null);
            return result;
        } catch (Throwable e) {
            e.printStackTrace();
            long t3 = System.currentTimeMillis();
            log.error("exception {}", t3);
            doLogInfo(joinPoint,(t3-t1),e);
            throw e;
        }

    }

    private void doLogInfo(ProceedingJoinPoint joinPoint, Long time, Throwable e) throws Throwable {
        //1.获取日志
        //1.1获取用户名
        String username = "Doraemon";

        //1.2.获取ip
        String ip = "200.100.10.11";

        //1.3获取操作
        //获取目标的字节码对象
        Class<?> tc = joinPoint.getTarget().getClass();
        //获取目标方法对象
        //获取方法签名信息
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
            //通过字节码对象以及方法信息获取目标方法对象
        Method targetMethod = tc.getDeclaredMethod(ms.getName(), ms.getParameterTypes());
            //获取方法上的requiredLog注解
        RequiredLog requiredLog = targetMethod.getAnnotation(RequiredLog.class);
        //获取注解中operation属性的值
        String operation = requiredLog.operation();

        //1.4获取方法信息
        String targetClaMethod = tc.getName()+"."+targetMethod;

        //1.5获取方法参数
        //获取实际参数值
        Object[] args = joinPoint.getArgs();
        //将参数值转换为json格式字符串
        String string = new ObjectMapper().writeValueAsString(args);

        //2.封装日志
        SysLog userLog = new SysLog();
        userLog.setUsername(username);
        userLog.setIp(ip);
        //获取切入点方法上RequiredLog注解中operation属性值
        userLog.setOperation(operation);
        //获取切入点方法的信息(方法所在的类+方法名)
        userLog.setMethod(targetClaMethod);
        //执行方法时调用的参数
        userLog.setParams(string);
        if(e!=null){
            //操作状态
            userLog.setStatus(0);
            //错误信息
            userLog.setError(e.getMessage());
        }
        userLog.setTime(time);
        userLog.setCreatedTime(new Date());


        //3.记录日志
        log.info("user.oper{}", new ObjectMapper().writeValueAsString(userLog));
    }
}
