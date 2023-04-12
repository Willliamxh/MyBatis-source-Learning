package com.bjp.proxy.staticProxy;

/**
 * @author XuHan
 * @date 2023/4/12 09:32
 */
public class TargetInterfaceImpl implements TargetInterface{
    @Override
    public void sayHello(String hello) {
        System.out.println(hello);
    }

    @Override
    public void sayThanks(String thanks) {
        System.out.println(thanks);
    }

}
