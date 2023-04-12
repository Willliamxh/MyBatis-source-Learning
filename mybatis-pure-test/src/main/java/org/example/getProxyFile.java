package org.example;

import com.bjp.proxy.jdk.JdkTargetInterface;
import com.bjp.proxy.jdk.JdkTargetInterfaceImpl;
import com.bjp.proxy.jdk.JdkTargetProxy;

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

        JdkTargetInterface proxySimple = (JdkTargetInterface) jdkTargetProxy.getProxySimple(targetInterfaceImpl);
        proxySimple.sayHello("hhhhhhh");

    }
}
