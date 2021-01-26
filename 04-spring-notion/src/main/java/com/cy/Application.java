package com.cy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类由@SpringBootApplication注解
 * 启动类在运行时都会做什么呢?
 * 1)通过ClassLoader(类加载器-负责将磁盘中的类读到内存中)将类加载到内存
 * 2)通过线程(Thread)调用io(InputStream)从磁盘(Disk)读取文件(File)信息
 * 3)读取类上的描述(@Component,@Service,@Controller,.....),并基于描述创建
 * 配置对象(BeanDefinition),存储类的配置信息(类全名,作用域,....).
 * 4)基于类的配置信息通过Bean工厂反射构建类的实例(对象),并进行存储(对象池-用时从池中取)
 * 5)当我们需要一个类的实例时可以从对象池(Bean池)获取即可.
 * JVM 参数分析
 * 1)检测类的加载:-XX:+TraceClassLoading
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
