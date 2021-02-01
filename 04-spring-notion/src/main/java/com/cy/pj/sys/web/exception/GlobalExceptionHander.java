package com.cy.pj.sys.web.exception;

import com.cy.pj.sys.web.pojo.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHander {
    private static final Logger log= LoggerFactory.getLogger(GlobalExceptionHander.class);

    @ExceptionHandler(RuntimeException.class)
    public JsonResult doHandleRuntimeException(RuntimeException e){
         e.printStackTrace();
         log.error("exception msg is {}",e.getMessage());
         return new JsonResult(e);
    }

    @ExceptionHandler(IllegalAccessException.class)
    public JsonResult doHandleRuntimeException(IllegalAccessException e){
        e.printStackTrace();
        log.error("exception msg is {}",e.getMessage());
        return new JsonResult(e);
    }
}
