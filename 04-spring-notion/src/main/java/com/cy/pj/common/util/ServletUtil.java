package com.cy.pj.common.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class ServletUtil {

    public static HttpServletRequest getRequest(){
        return getServletRequestAttributes().getRequest();
    }

    public static ServletRequestAttributes getServletRequestAttributes(){
        return (ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes();
    }

}
