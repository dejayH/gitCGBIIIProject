package com.cy.java.basic;

public class TestAopS extends TsetAop{
    public static void main(String[] args) {
        new TestAopS().test();
    }
    public void test(){
        System.out.println(0);
        super.num();
        System.out.println(2);
    }
}
