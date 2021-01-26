package com.cy.java.oop;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ObjectTests {

    public static void main(String[] args)
            throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //构建对象(传统方式)
        Object o1=new Object();//编译时确定构建对象方式(对象构建时需要构造方法)
        //构建对象(反射方式-API->不能预知未来,但可以驾驭未来)
        //反射的起点是谁?Class类型的对象
        //如何获取Class类型的对象呢?(Class类型的对象又称之为字节码对象,一个JVM只能有一份)
        //1.通过类名.class方式
        Class<?> c1=Object.class;//需要在编译时就知道Object类
        //2.通过对象实例.getClass方式
        Class<?> c2=o1.getClass();//需要在编译时就知道Object类
        //3.通过Class.forName的方式
        Class<?> c3=Class.forName("java.lang.Object");//
        System.out.println(c1==c2);//true
        System.out.println(c2==c3);//true
        //通过字节码对象获取无参构造方法对象
        Constructor<?> constructor =
                c3.getConstructor();//getConstructor(Class<?>... parameterTypes)
        //通过构造方法对象构建类的实例对象
        Object o2=constructor.newInstance();//newInstance(Object ... initargs)
        Object o3=c3.newInstance();


    }
}
