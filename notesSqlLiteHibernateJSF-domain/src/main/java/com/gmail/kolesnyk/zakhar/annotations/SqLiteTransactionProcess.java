package com.gmail.kolesnyk.zakhar.annotations;


import java.lang.reflect.Method;

public class SqLiteTransactionProcess {
    public static void main(String[] args) {


        inspect(TestClass.class);
//        TestClass.print();
    }
    static void inspect(Class<?> clazz){
        Method[] methods=clazz.getMethods();
        for (Method m: methods){
            if (m.isAnnotationPresent(SqLiteTransaction.class)) {
                System.out.println(m);
            }
        }
//        System.out.println(isAnnotationPresent(SqLiteTransaction.class));
    }
}
