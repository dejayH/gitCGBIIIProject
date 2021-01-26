package com.cy.java.reflect;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class PackageTests {
    public static void main(String[] args) {
        //获取类的
        Class<?> c = PackageTests.class;
        Package aPackage = c.getPackage();
        String name = aPackage.getName();
        System.out.println(name);
        String dirname = name.replace(".", "/");
        System.out.println(dirname);
        //通过类加载器获取dirName对应的绝对路径
        URL url =
                ClassLoader.getSystemClassLoader().getResource(dirname);
        File file = new File(url.getPath());
        String files[] = file.list();
        for (String s : files) {
            System.out.println(s);
        }

    }
}
