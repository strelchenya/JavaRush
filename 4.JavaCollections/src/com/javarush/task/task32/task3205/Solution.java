package com.javarush.task.task32.task3205;

import jdk.internal.dynalink.linker.LinkerServices;

import java.lang.reflect.Proxy;

/* 
Создание прокси-объекта
*/

public class Solution {
    public static void main(String[] args) {
        SomeInterfaceWithMethods obj = getProxy();
        obj.stringMethodWithoutArgs();
        obj.voidMethodWithIntArg(1);

        /* expected output
        stringMethodWithoutArgs in
        inside stringMethodWithoutArgs
        stringMethodWithoutArgs out
        voidMethodWithIntArg in
        inside voidMethodWithIntArg
        inside voidMethodWithoutArgs
        voidMethodWithIntArg out
        */
    }

    public static SomeInterfaceWithMethods getProxy() {

        SomeInterfaceWithMethods proxy = (SomeInterfaceWithMethods) Proxy.newProxyInstance(
                SomeInterfaceWithMethods.class.getClassLoader(),
                new Class[]{SomeInterfaceWithMethods.class},
                new CustomInvocationHandler(new SomeInterfaceWithMethodsImpl()));
        return proxy;
    }
}
