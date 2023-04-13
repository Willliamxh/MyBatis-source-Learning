package com.bjp.Generic;

/**
 * @author XuHan
 * @date 2023/4/13 13:47
 */
public class Test2 {
    public static void main(String[] args) {
        //[? super Fruit]告诉编译器的是，Plate里面都是【Fruit+Fruit的父类】
        //所以Plate里面任何元素的父类必然是Fruit或Fruit的父类，下界为Fruit
        //因为子类可以用一个父类接收，所以可以set【Fruit+Fruit的子类】(核心在这里)
        //但是get的时候，无法确定是Fruit的哪个父类，所以只能用Object接收
        Plate<? super Fruit> superPlate = new Plate<>();
        Apple apple = new Apple();
        superPlate.set(apple);

        // superPlate.set(new String());
    }
}

class Fruit {}

class Apple extends Fruit {}


class Plate<T>{
    private T item;
    // public Plate(T t){item=t;}
    public void set(T t){item=t;}
    public T get(){return item;}
}

