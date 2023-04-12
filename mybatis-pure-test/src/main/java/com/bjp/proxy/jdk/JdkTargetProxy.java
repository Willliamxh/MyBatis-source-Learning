package com.bjp.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author XuHan
 * @date 2023/4/12 09:44
 * 实现JDK代理提供的InvocationHandler接口
 *
 * 实现该接口是为了实现jdk的动态代理
 *
 * 这个类不是真正的代理类，整整的代理类在jvm内存中，我们看不见摸不着的（但是可以通过设置让它这个.class存储在本地）这个真正的代理名字一般是$Proxy
 */
public class JdkTargetProxy implements InvocationHandler {

    /**
     * 持有目标类接口的引用，动态代理是为了适配个钟目标类型，所以就用了Object类
     */
    private final Object target;

    /**
     * 通过构造方法传入目标类
     * @param target
     */
    public JdkTargetProxy(Object target) {
        this.target = target;
    }

    /**
     * 覆盖InvocationHandler的incoke方法
     * 该方法会对目标方法进行拦截
     *
     *
     * @param proxy the proxy instance that the method was invoked on
     *              就是我们的代理类，就是jdk生成的那个$Proxy.代理类
     *
     * @param method the {@code Method} instance corresponding to
     * the interface method invoked on the proxy instance.  The declaring
     * class of the {@code Method} object will be the interface that
     * the method was declared in, which may be a superinterface of the
     * proxy interface that the proxy class inherits the method through.
     *               就是目标接口的方法，比如sayhi() say thanks()的反射对象Method
     *
     * @param args an array of objects containing the values of the
     * arguments passed in the method invocation on the proxy instance,
     * or {@code null} if interface method takes no arguments.
     * Arguments of primitive types are wrapped in instances of the
     * appropriate primitive wrapper class, such as
     * {@code java.lang.Integer} or {@code java.lang.Boolean}.
     *             代理实例中调用方法时传入的参数
     *
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("前置增强（通知）……………………");

        Object result = method.invoke(target, args);

        System.out.println("后置增强通知……………………");

        return result;
    }

    /**
     * 这边是那个老师的写法 传入的是被代理的实例的接口
     * @param interfaces
     * @return
     * @param <T>
     */
    public <T> T getProxy(Class interfaces){
       return  (T) Proxy.newProxyInstance(interfaces.getClassLoader(),
               new Class<?>[]{interfaces},
               this);

    }

    /**
     * 这边传入一个被代理类的实例 这样写会更清楚简单点
     * @param target
     * @return
     */
    public Object getProxySimple(Object target){
        //1.jvm内存中生成了class类
        //2.根据这个class类反射创建一个代理对象$Proxy2345

        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                //这样写是更好的，因为这样如果这个类继承了多个接口，按照上面的方法还得写好多接口
                target.getClass().getInterfaces(),
                this);
    }

    public Object getTarget() {
        return target;
    }
}
