package com.cy.pj.sys.web.config;

import com.cy.pj.sys.web.interceptor.TimeAccessInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry){
                //注册拦截器(将拦截器添加到spring容器)
        registry.addInterceptor(new TimeAccessInterceptor())
                //设置拦截URL
                .addPathPatterns("/notice/**");
    }

}
