package com.bjp.proxy.cglib;

/**
 * @author XuHan
 * @date 2023/4/12 14:49
 */
public class TestCgLib {
    public static void main(String[] args) {

        CglibTargetInterfaceImpl cglibTargetInterfaceImpl = new CglibTargetInterfaceImpl();

        //cglib 通过DebuggingClassWriter的方式方便我们把动态代理类的文件写到本地
        //输出cglib动态代理产生的类
        // System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/xuhan/program/program/workLearning/learn-mybatis-source/mybatis-pure-test/target/classes/com/cglib");

        CglibProxy cglibProxy = new CglibProxy();
        // 生成代理类 CglibTargetInterfaceImpl$$EnhancerByCGLIB$$fc83bcf1
        CglibTargetInterface proxy = cglibProxy.getProxy(CglibTargetInterfaceImpl.class);
        proxy.sayHello("hello");

        // CglibTargetInterface simpleProxy = (CglibTargetInterface)cglibProxy.getSimpleProxy(new CglibTargetInterfaceImpl());
        // simpleProxy.sayHello("hello");

    }
}
