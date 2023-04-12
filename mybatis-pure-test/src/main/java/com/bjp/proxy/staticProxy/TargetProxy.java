package com.bjp.proxy.staticProxy;

/**
 * @author XuHan
 * @date 2023/4/12 09:34
 */
public class TargetProxy implements TargetInterface{

    /**
     * 持有目标接口的引用
     */
    private final TargetInterface targetInterface;

    public TargetProxy(TargetInterface targetInterface) {
        this.targetInterface = targetInterface;
    }

    @Override
    public void sayHello(String hello) {
        System.out.println("start666666666");

        targetInterface.sayHello(hello);

        System.out.println("end 666666666");

    }

    @Override
    public void sayThanks(String thanks) {

        System.out.println("start666666666");

        targetInterface.sayThanks(thanks);

        System.out.println("end 666666666");
    }

    public TargetInterface getTargetInterface() {
        return targetInterface;
    }
}
