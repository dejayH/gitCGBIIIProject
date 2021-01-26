package com.cy.java.reflect;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Component {
}

@Component
class ClassA {
}

public class AnnotionTests {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //检查ClassA上是否有@Component注解描述
        //1.获取类的字节码对象
        Class<?> c = Class.forName("com.cy.java.reflect.ClassA");
        //2.判定对象上是否有注解
        boolean flag = c.isAnnotationPresent(Component.class);
        System.out.println(flag);
        if (flag) {
            Object ob1 = c.newInstance();//反射构建类的实例
            System.out.println(ob1);
        }
        //Annotation类型是所有注解的父类类型
        Annotation atn = c.getAnnotation(Component.class);
        System.out.println(atn);
    }
}
