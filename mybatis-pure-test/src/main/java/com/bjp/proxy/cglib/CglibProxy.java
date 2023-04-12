package com.bjp.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author XuHan
 * @date 2023/4/12 14:23
 * TargetProxy类还不是一个真正的代理类，它是代理类的一部分
 */
public class CglibProxy implements MethodInterceptor {

    public <T> T getProxy(Class<T> tClass){
        //字节码增强的一个类
        Enhancer enhancer = new Enhancer();

        //设置父类（因为cglib是通过继承实现的）
        enhancer.setSuperclass(tClass);
        //或者设置接口
        // enhancer.setInterfaces(new Class[]{tClass});

        //设置回调类
        enhancer.setCallback(this);

        //创建代理类
        return (T)enhancer.create();
    }

    /**
     * target表示目标对象，paramTypes和params表示目标方法的参数类型和参数值，methodInterceptor表示拦截器。
     * @param target

     * @return
     */
    public Object getSimpleProxy(Object target){
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(target.getClass());

        enhancer.setCallback(this);

        return enhancer.create();
    }

    /**
     *
     * @param o
     * @param method
     * @param args
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println(method.getName()+"  前置通知");

        //todo 这边注意 是methodProxy.invokeSuper 不是method.invoke
        //todo 两个点 methodProxy  和 invokeSuper

        Object result = methodProxy.invokeSuper(o, args);
        //如果调用的是接口 那就不能调用methodProxy.invokeSuper(o, args)
        //那就得我们自己实现接口
        //System.out.println("自己实现接口，不能调用methodProxy.invokeSuper(o, args)");

        System.out.println(method.getName()+"  后置通知");


        return result;
    }


}
