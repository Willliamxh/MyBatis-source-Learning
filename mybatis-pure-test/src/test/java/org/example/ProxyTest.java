package org.example;

import com.bjp.proxy.jdk.JdkTargetInterface;
import com.bjp.proxy.jdk.JdkTargetInterfaceImpl;
import com.bjp.proxy.jdk.JdkTargetProxy;
import com.bjp.proxy.staticProxy.TargetInterfaceImpl;
import com.bjp.proxy.staticProxy.TargetProxy;
import org.junit.Test;

/**
 * @author XuHan
 * @date 2023/4/12 09:38
 */
public class ProxyTest {


    @Test
    public void staticProxy(){

        TargetInterfaceImpl targetInterface = new TargetInterfaceImpl();
        TargetProxy targetProxy = new TargetProxy(targetInterface);

        targetProxy.sayHello("hello");
        System.out.println("____________________");
        targetProxy.sayThanks("thanks");

    }

    @Test
    public void jdkProxy(){
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
