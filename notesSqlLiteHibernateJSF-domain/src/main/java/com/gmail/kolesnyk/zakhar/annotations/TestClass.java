package com.gmail.kolesnyk.zakhar.annotations;


public class TestClass {

    @SqLiteTransaction
    public static void print(){
        System.out.println("TestClass.print");
    }

    public static void nonAnn(){

    }
}
