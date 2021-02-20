package com.cy;

import org.apache.shiro.realm.Realm;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@EnableCaching//启动springboot内置缓存
@SpringBootApplication
public class AdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }
    /**配置realm对象(org.apache.shiro.realm.Realm)
     * @Bean注解描述方法是,表示方法的返回值要交给spring管理
     * */
    @Bean
    public Realm realm(){
        return null;
    }
}
