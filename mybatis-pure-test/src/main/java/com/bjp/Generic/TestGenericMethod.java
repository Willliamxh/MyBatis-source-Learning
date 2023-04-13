package com.bjp.Generic;

import java.lang.reflect.InvocationTargetException;

/**
 * @author XuHan
 * @date 2023/4/12 21:35
 * 4、泛型方法
 * 泛型类，是在实例化类的时候指明泛型的具体类型；
 *
 * 泛型方法，是在调用方法的时候指明泛型的具体类型。
 */
public class TestGenericMethod {


    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {


        Object o = genericMethod(Class.forName("java.lang.String"));
        //
        // System.out.println("".equals(o));

        // Class<?> aClass = Class.forName("java.lang.String");
        // aClass.newInstance();
        // Object o = aClass.newInstance(10);

        // Class<?> clazz = Class.forName("java.lang.Integer");
        // Method valueOfMethod = clazz.getMethod("valueOf", int.class);
        // Integer intValue = (Integer) valueOfMethod.invoke(null, 10);
        // System.out.println(intValue);

        // String str = "hello, reflection!";
        // Method method = String.class.getMethod("toUpperCase");
        // String result = (String) method.invoke(str);
        // System.out.println(result);


        printMsg("1111",2222,"江疏影","0.00",55.55);



    }
    /**
     * 泛型方法的基本介绍
     * @param tClass 传入的泛型实参
     * @return T 返回值为T类型
     * 说明：
     *     1）public 与 返回值中间<T>非常重要，可以理解为声明此方法为泛型方法。
     *     2）只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法。
     *     3）<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
     *     4）与泛型类的定义一样，此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型。
     */
    public static <T> T genericMethod(Class<T> tClass) throws InstantiationException, IllegalAccessException {
        T t = tClass.newInstance();
        return t;
    }

    //静态方法中使用泛型，必须要将泛型定义在方法上。
    public static <T> void printMsg(T...args){
        for(T t:args){
            System.out.println("泛型测试，it is "+t);
        }
    }

}
