package com.cy.pj.sys.web.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.time.LocalTime;
import java.util.Map;

@Slf4j
public class TimeAccessInterceptor implements HandlerInterceptor {
    //    private static final Logger log =LoggerFactory.getLogger(TimeAccessInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        testRequestInfo(request,handler);
        LocalTime now = LocalTime.now();
        int hour = now.getHour();
        log.info("hour{}", hour);
        if (hour < 6 || hour >= 22) {
            throw new RuntimeException("请在6点~10点进行访问");
        }
        return true;
    }

    private void testRequestInfo(HttpServletRequest request, Object handler) {
        String uri = request.getRequestURI();
        System.out.println("request.uri =" + uri);
        Map<String, String[]> map = request.getParameterMap();
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        System.out.println("method.name->" + method.getName());
        System.out.println("==preHandle==");
    }
}
