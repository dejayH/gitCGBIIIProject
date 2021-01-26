package com.cy.java.oop;

import com.cy.java.Util.ReflectUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

public class ReflectTests {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        //作业:
        //1.通过反射构建Point类型的实例对象
        //1.1获取反射应用的起点对象(类的字节码对象)
        Class<?> c1 = Class.forName("com.cy.java.oop.Point");
        //1.2基于字节码对象获取类的构造方法对象
//        Constructor<?> constructor =
//                c1.getConstructor(int.class, int.class);
//        Object o1 = constructor.newInstance(10, 20);
//        System.out.println(o1);
        Object o1 = ReflectUtil.newInstance("com.cy.java.oop.Point",
                                                        new Object[]{10, 20},
                                                        int.class, int.class);

        //2.通过反射为point类实例的属性直接赋值
        Field f1 = c1.getDeclaredField("x");
        f1.setAccessible(true);//设置可访问
        f1.set(o1, 1000);//为point对象的f1属性赋值为1000
        System.out.println(o1);
        //3.通过反射调用point类的实例set方法为属性赋值
        Method setMethod = c1.getDeclaredMethod("setX", int.class);
        setMethod.invoke(o1, 2000);//为o1对象的setMethod方法赋值为2000
        System.out.println(o1);
        //4.通过反射调用point类的get方法获取属性值.
        Method getMethod = c1.getMethod("getX");
        Object getResult = getMethod.invoke(o1);
        System.out.println(getResult);
    }
}
