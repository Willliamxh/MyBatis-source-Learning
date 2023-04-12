package com.bjp.proxy.jdk;

/**
 * @author XuHan
 * @date 2023/4/12 11:11
 */
public class getProxyFile {
    public static void main(String[] args) {
        //这边
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");


        JdkTargetInterfaceImpl targetInterfaceImpl = new JdkTargetInterfaceImpl();

        JdkTargetProxy jdkTargetProxy = new JdkTargetProxy(targetInterfaceImpl);
        // JdkTargetInterface proxy = (JdkTargetInterface) jdkTargetProxy.getProxy(JdkTargetInterface.class);
        // proxy.sayHello("hello");

        //真正的代理对象$Proxy0对象，
        JdkTargetInterface proxySimple = (JdkTargetInterface) jdkTargetProxy.getProxySimple(targetInterfaceImpl);
        //这里其实相当于是调$Proxy0 的super.h.invoke(this, m4, new Object[]{var1});
        proxySimple.sayHello("hhhhhhh");

    }
}
