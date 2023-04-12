//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.bjp.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * 这边把代理类的反编译代码给复制出来了 其实是不符合很多规范的
 * @see /Users/xuhan/program/program/workLearning/learn-mybatis-source/com/sun/proxy/$Proxy0.class
 */
public final class $Proxy0 extends Proxy implements JdkTargetInterface {
    private static Method m1;
    private static Method m4;
    private static Method m2;
    private static Method m0;
    private static Method m3;

    public $Proxy0() throws Exception {
        this(null);
    }

    public $Proxy0(InvocationHandler var1) throws Exception {
        super(var1);
    }

    public final boolean equals() throws Exception {
        return equals(null);
    }

    @Override
    public final boolean equals(Object var1) {
        try {
            return (Boolean)super.h.invoke(this, m1, new Object[]{var1});
        } catch (RuntimeException | Error var3) {
            throw var3;
        } catch (Throwable var4) {
            throw new UndeclaredThrowableException(var4);
        }
    }

    @Override
    public final void sayHello(String var1)   {
        try {
            //这边的h 其实就是我们继承了invocationHandler接口的那个JdkTargetProxy 的invoke()方法
            //我在创建这个$Proxy0对象的时候，会把这个h初始化 初始化代码：java.lang.reflect.Proxy.newProxyInstance(ClassLoader loader,
            //                                           Class<?>[] interfaces,
            //                                           InvocationHandler h)
            // 中的，return cons.newInstance(new Object[]{h}); 就是拿到了构造器（是通过反射，cl.getConstructor(constructorParams)，cl(其实就是我的$Proxy0 这个类)使用getConstructor()方法获取到指定参数类型（constructorParams）的构造器，拿的是protected Proxy(InvocationHandler h)这个构造方法）
            // 后 会把我们传进去的InvocationHandler h 给传到构造器里面，这个时候就把这个h初始化了
            super.h.invoke(this, m4, new Object[]{var1});
        } catch (RuntimeException | Error var3) {
            throw var3;
        } catch (Throwable var4) {
            throw new UndeclaredThrowableException(var4);
        }
    }

    @Override
    public final String toString()   {
        try {
            return (String)super.h.invoke(this, m2, (Object[])null);
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }

    @Override
    public final int hashCode()   {
        try {
            return (Integer)super.h.invoke(this, m0, (Object[])null);
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }
    @Override
    public final void sayThanks(String var1) {
        try {
            super.h.invoke(this, m3, new Object[]{var1});
        } catch (RuntimeException | Error var3) {
            throw var3;
        } catch (Throwable var4) {
            throw new UndeclaredThrowableException(var4);
        }
    }

    static {
        try {
            m1 = Class.forName("java.lang.Object").getMethod("equals", Class.forName("java.lang.Object"));
            m4 = Class.forName("com.bjp.proxy.jdk.JdkTargetInterface").getMethod("sayHello", Class.forName("java.lang.String"));
            m2 = Class.forName("java.lang.Object").getMethod("toString");
            m0 = Class.forName("java.lang.Object").getMethod("hashCode");
            m3 = Class.forName("com.bjp.proxy.jdk.JdkTargetInterface").getMethod("sayThanks", Class.forName("java.lang.String"));
        } catch (NoSuchMethodException var2) {
            throw new NoSuchMethodError(var2.getMessage());
        } catch (ClassNotFoundException var3) {
            throw new NoClassDefFoundError(var3.getMessage());
        }
    }
}
