package com.bjp.Generic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author XuHan
 * @date 2023/4/13 15:25
 * 有界类型参数（bounded type parameters），用于限制实际参数的类型范围。举例如下：
 *
 */
public class BoundedType {

    /**
     * 事实上，这段代码是有问题的，这是一个普通的类，写了一个泛型方法，
     * 这个方法做的事情是比较两个数，传进两个数返回一个最小值，我们怎么确定传进来的 a和 b 都有compareTo方法呢，这就用到了类型变量的限定。
     * @param a
     * @param b
     * @return
     * @param <T>
     */
    // public static <T> T min(T a,T b){
    //     if(a.compareTo(b)>0) {
    //         return a;
    //     } else {
    //         return b;
    //     }
    // }

    /**
     *
     */
    public static <T extends Comparable> T main1(T a,T b){
        if(a.compareTo(b)>0) {
            return a;
        } else {
            return b;
        }
    }
    public static <T extends Comparable> T main2(T a,T b){
        if(a.compareTo(b)>0) {
            return a;
        } else {
            return b;
        }
    }
    public static <T,V extends Test&Comparable> T test3(T a,T b){
//        if(a.compareTo(b)>0) return a;
//        else  return b;
        return  a;
    }
    static class Test{}

    /**
     * extends Comparable 限定了这个泛型，传进的值必须实现了或者继承了Comparable这个接口，
     * 如果传进没有实现或继承Comparable的类或者接口，会在编译器就会报错，提示你传入的类型不对，
     * 限定类型是可以传多个接口的，如果是类和接口混用的话，类只能有一个，
     * 并且要放到第一个，放到第一个是java语法的规范。多个限定类型用&连接，泛型方法可以这样限定，泛型类和泛型接口接口也同样可以这样限定。
     */

    // Class A { /* ... */ }
    // interface B { /* ... */ }
    // interface C { /* ... */ }
    //
    // class D <T extends A & B & C> { /* ... */ }


    /**
     * 原因是编译器只知道容器内是Fruit或者它的派生类，但具体是什么类型不知道。可能是Fruit？可能是Apple？
     * 也可能是Banana，RedApple，GreenApple？编译器在看到后面用Plate<Apple>赋值以后，盘子里没有被标上有“苹果”。而是标上一个占位符：CAP#1，
     * 来表示捕获一个Fruit或Fruit的子类，具体是什么类不知道，代号CAP#1。然后无论是想往里插入Apple或者Meat或者Fruit编译器都不知道能不能和这个CAP#1匹配，
     * 所以就都不允许。所以通配符<?>和类型参数<T>的区别就在于，对编译器来说所有的T都代表同一种类型。比如下面这个泛型方法里，三个T都指代同一个类型，要么都是String，要么都是Integer。
     *
     * 作者：胖君
     * 链接：https://www.zhihu.com/question/20400700/answer/117464182
     * 来源：知乎
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param list
     */
    public void test23423(List<? extends Number> list) {
        Number number = new Integer(1);
        // list.add(number); // Error
        Integer integer = new Integer(2);
        // list.add(integer); // Error
        list.add(null); // OK
    }

    static <T> T pick(T a1, T a2) { return a2; }

    public static void main(String[] args) {
        Serializable d = pick("d", new ArrayList<String>());
    }



}
