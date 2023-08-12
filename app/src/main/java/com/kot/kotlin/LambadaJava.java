package com.kot.kotlin;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambadaJava {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("apple", "pear", "banana", "watermelon");

        //老的方式
//        for (String x : list) {
//            System.out.println(x);
//        }

        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });


    }
}
