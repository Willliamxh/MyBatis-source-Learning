package com.bjp.Generic;

/**
 * @author XuHan
 * @date 2023/4/12 20:25
 *
 * 3.泛型通配符
 *
 * 为什么要用通配符呢?
 *
 * 在java中，数组是可以协变的，比如dog extends Animal，那么Animal[] 与dog[]是兼容的。
 * 而集合是不能协变的，也就是说List<Animal>不是List<dog>的父类，这时候就可以用到通配符了。
 *
 * 1. 无边界的通配符(Unbounded Wildcards), 就是<?>, 比如List<?>.
 * 　　无边界的通配符的主要作用就是让泛型能够接受未知类型的数据.
 * 2. 固定上边界的通配符(Upper Bounded Wildcards):
 * 　　使用固定上边界的通配符的泛型, 就能够接受指定类及其子类类型的数据. 要声明使用该类通配符, 采用<? extends E>的形式, 这里的E就是该泛型的上边界. 注意: 这里虽然用的是extends关键字, 却不仅限于继承了父类E的子类, 也可以代指显现了接口E的类.
 * 3. 固定下边界的通配符(Lower Bounded Wildcards):
 * 　　使用固定下边界的通配符的泛型, 就能够接受指定类及其父类类型的数据. 要声明使用该类通配符, 采用<? super E>的形式, 这里的E就是该泛型的下边界. 注意: 你可以为一个泛型指定上边界或下边界, 但是不能同时指定上下边界.
 *
 * https://juejin.cn/post/6911302681583681544#heading-4
 * https://blog.csdn.net/swadian2008/article/details/100611243
 * https://www.cnblogs.com/wxw7blog/p/7517343.html
 *
 * 大佬文章：
 * https://www.cnblogs.com/zhenyu-go/p/5536667.html 后面那个讲的不是很清楚
 *
 * https://www.zhihu.com/question/20400700/answer/117464182 这个讲的还可
 *
 *
 *
 */
public class TestGenericWildcard {
    public static void main(String[] args) {

        Generic<Integer> genericInteger = new Generic<Integer>(123456);

        Generic<Number> genericNumber = new Generic<Number>(123);

        Generic<Double> genericDouble = new Generic<Double>(123.2);

        //这个会报错
        // 在java中，数组是可以协变的，比如dog extends Animal，那么Animal[] 与dog[]是兼容的。
        // 而集合是不能协变的，也就是说List<Animal>不是List<dog>的父类，这时候就可以用到通配符了。
        // getValueByT(genericInteger);
        //回到上面的例子，如何解决上面的问题？总不能为了定义一个新的方法来处理Generic类型的类，这显然与java中的多台理念相违背。
        // 因此我们需要一个在逻辑上可以表示同时是Generic和Generic父类的引用类型。由此类型通配符应运而生。
        // getValueByT(genericNumber);

        getValueByWithTpf(genericInteger);

        getValueByWithTpf(genericNumber);

        getValueByWithTpf(genericDouble);




    }

    public static void getValueByT(Generic<Number> obj){
        System.out.println(obj.getKey());
    }

    public static void getValueByWithTpf(Generic<?> obj){
        System.out.println(obj.getKey());
    }

    public <T> void getValue(Generic<T> obj){

    }

}
