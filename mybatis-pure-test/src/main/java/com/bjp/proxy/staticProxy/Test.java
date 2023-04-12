package com.bjp.proxy.staticProxy;

/**
 * @author XuHan
 * @date 2023/4/12 14:21
 */
public class Test {
    public static void main(String[] args) {
        TargetInterfaceImpl targetInterface = new TargetInterfaceImpl();
        TargetProxy targetProxy = new TargetProxy(targetInterface);

        targetProxy.sayHello("hello");
        System.out.println("____________________");
        targetProxy.sayThanks("thanks");

    }
}
