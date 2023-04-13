package com.bjp.Generic;

/**
 * @author XuHan
 * @date 2023/4/12 20:16
 * 2.泛型接口
 * 泛型接口与泛型类的定义及使用基本相同。泛型接口常被用在各种类的生产器中，可以看一个例子：
 */
public interface Generator<T> {
    /**
     * 泛型接口方法
     * @return T
     */
    public T next();
}
