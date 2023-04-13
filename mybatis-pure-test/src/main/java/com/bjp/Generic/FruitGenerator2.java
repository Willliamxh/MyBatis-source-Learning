package com.bjp.Generic;

import java.util.Random;

/**
 * @author XuHan
 * @date 2023/4/12 20:21
 */
public class FruitGenerator2 implements Generator<String>{

    String[] fruits = new String[]{"apple","banana","Pear"};

    @Override
    public String next() {
        Random random = new Random();
        System.out.println(fruits[random.nextInt(3)]);
        return fruits[random.nextInt(3)];
    }

    public static void main(String[] args) {
        FruitGenerator2 fruitGenerator2 = new FruitGenerator2();

        System.out.println(fruitGenerator2.next());
    }
}
