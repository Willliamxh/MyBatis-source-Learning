package org.example;

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
}
